package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.SuiteTesteSequencia;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class SuiteTesteSequenciaDAO {

    public static List getAll() {
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteSequencia.findAll");

       List<SuiteTesteSequencia> lstSTS = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstSTS;
    }

    public static SuiteTesteSequencia getSuiteTesteSequencia(String nome) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteSequencia.findByNome");
       q.setParameter("nome", nome);

       SuiteTesteSequencia suite = null;

       if (q.getResultList().size() > 0)
           suite = (SuiteTesteSequencia)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return suite;
    }

    public static SuiteTesteSequencia getSuiteTesteSequencia(int id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteSequencia.findById");
       q.setParameter("id", id);

       SuiteTesteSequencia suite = null;

       if (q.getResultList().size() > 0)
           suite = (SuiteTesteSequencia)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return suite;
    }

    public static int save(SuiteTesteSequencia suite) {

        int retorno = 0;
        SuiteTesteSequencia suiteSalva = getSuiteTesteSequencia(suite.getNome());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (suiteSalva == null) {
            TesteDBManager.entityManager().persist(suite);
        }
        else {
            //TesteDBManager.entityManager().merge(suite);
            retorno = 1;
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

    public static int delete(String nome) throws RollbackException {

       int retorno = 1;
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteSequencia.findByNome");
       q.setParameter("nome", nome);


       try {
            if (q.getResultList().size() > 0) {
              TesteDBManager.entityManager().remove(q.getResultList().get(0));
            }

            transaction.commit();
       }
       catch(RollbackException e) {
           TesteDBManager.closeConnection();
           throw e;
       }
       catch(Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
       }

       TesteDBManager.closeConnection();
       return retorno;
    }

    public static int saveById(SuiteTesteSequencia suite) {

        int retorno = 0;
        SuiteTesteSequencia suiteSalvo = getSuiteTesteSequencia(suite.getId().intValue());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (suiteSalvo != null) {
            suiteSalvo.setNome(suite.getNome());
            TesteDBManager.entityManager().merge(suiteSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(suite);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }
}

