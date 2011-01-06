package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.SuiteTesteValidacao;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class SuiteTesteValidacaoDAO {

    public static List getAll() {
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteValidacao.findAll");

       List<SuiteTesteValidacao> lstSTV = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       Collections.sort(lstSTV);
       return lstSTV;
    }

    public static SuiteTesteValidacao getSuiteTesteValidacao(String nome) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteValidacao.findByNome");
       q.setParameter("nome", nome);

       SuiteTesteValidacao suite = null;

       if (q.getResultList().size() > 0)
           suite = (SuiteTesteValidacao)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return suite;
    }

    public static SuiteTesteValidacao getSuiteTesteValidacao(int id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteValidacao.findById");
       q.setParameter("id", id);

       SuiteTesteValidacao suite = null;

       if (q.getResultList().size() > 0)
           suite = (SuiteTesteValidacao)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return suite;
    }

    public static int save(SuiteTesteValidacao suite) {

        int retorno = 0;
        SuiteTesteValidacao suiteSalva = getSuiteTesteValidacao(suite.getNome());

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

       try {
           //Primeiro é necessário remover todos os vinculos existentes entre esta suite
           //e os casos de teste de validação
           retorno = SuiteValCarTstValDAO.delete(getSuiteTesteValidacao(nome));
    
           EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
           transaction.begin();

           Query q = TesteDBManager.entityManager().createNamedQuery("SuiteTesteValidacao.findByNome");
           q.setParameter("nome", nome);


           if (q.getResultList().size() > 0) {
             TesteDBManager.entityManager().remove(q.getResultList().get(0));
           }
           transaction.commit();
       }
       catch(RollbackException e) {
           TesteDBManager.closeConnection();
           throw new RollbackException("Suite de Teste de Validação " + nome + " possui vinculo com outras entidades");
       }
       catch(Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
       }
       
       TesteDBManager.closeConnection();
       return retorno;
    }

    public static int saveById(SuiteTesteValidacao suiteVal) {

        int retorno = 0;
        SuiteTesteValidacao suiteValidacaoSalvo = getSuiteTesteValidacao(suiteVal.getId().intValue());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (suiteValidacaoSalvo != null) {
            suiteValidacaoSalvo.setNome(suiteVal.getNome());
            TesteDBManager.entityManager().merge(suiteValidacaoSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(suiteVal);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }
}
