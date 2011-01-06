package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.Regra;
import javax.persistence.EntityTransaction;

public class RegraDAO {

    public static int save(Regra regra) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        TesteDBManager.entityManager().persist(regra);

        transaction.commit();
        TesteDBManager.closeConnection();

        return 0;

    }

}
