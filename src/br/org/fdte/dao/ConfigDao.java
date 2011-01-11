package br.org.fdte.dao;

import br.org.fdte.persistence.Config;
import javax.persistence.EntityTransaction;
import br.connection.db.persistencia.TesteDBManager;
import javax.persistence.Query;

public class ConfigDao {

    public static Config get(Long id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("Config.findById");
       q.setParameter("id", id);
       
       Config configRetornado = null;

       if (q.getResultList().size() > 0) {
           configRetornado = (Config)q.getResultList().get(0);
       }

       transaction.commit();
       TesteDBManager.closeConnection();

       return configRetornado;

    }

    public static int save(Config config) {

        int retorno = 0;
        Config cfgSalva = get(config.getId());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (cfgSalva != null) {
            cfgSalva.setWorkflowdir(config.getWorkflowdir());
            cfgSalva.setTestecasedir(config.getTestecasedir());
            cfgSalva.setResultdir(config.getResultdir());
            TesteDBManager.entityManager().merge(cfgSalva);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(config);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

}
