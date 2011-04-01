package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.AtivacaoTesteValidacao;
import br.org.fdte.persistence.ExecucaoTesteValidacao;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class AtivacaoTesteValidacaoDAO {

    /*public static void deleteByExecution(ExecucaoTesteValidacao idExecution) throws RollbackException {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        try {
            Query q = TesteDBManager.entityManager().createNamedQuery("AtivacaoTesteValidacao.deleteByExecution");
            q.setParameter("execution", idExecution);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        transaction.commit();
        TesteDBManager.closeConnection();
    }*/

   /* public static int save(AtivacaoTesteValidacao ativ) {

        int retorno = 0;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        try {

            if (ativ.getId() == null) {
                TesteDBManager.entityManager().persist(ativ);
            } else {
                TesteDBManager.entityManager().merge(ativ);
            }
        } catch (Exception e) {
            System.out.println("*************ERRO ao salvar uma ativacao************" + e.getMessage());
            retorno = -1;
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }*/

   /* public static Collection<AtivacaoTesteValidacao> findGoldenActivations(CaracterizacaoTesteValidacao ctv, SuiteTesteValidacao suite) throws Exception {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findGoldenExecution");
        q.setParameter("modoAtivacao", "G");
        q.setParameter("idCaractTstValidacao", ctv);
        q.setParameter("idSuite", suite);

        Collection<ExecucaoTesteValidacao> execs = q.getResultList();

        transaction.commit();
        TesteDBManager.closeConnection();

        if (execs != null && execs.size() > 0) {
            return execs.iterator().next().getAtivacaoTesteValidacaoCollection();
        } else {
            Collection<AtivacaoTesteValidacao> ativ = new ArrayList();
            return ativ;
        }
    } // findGoldenActivations
    * 
    */

    /*public static List<AtivacaoTesteValidacao> findByExecution(ExecucaoTesteValidacao idExec, String resultado) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();
        List<AtivacaoTesteValidacao> ativs = null;

        try {
            Query q = TesteDBManager.entityManager().createNamedQuery("AtivacaoTesteValidacao.findByIdExec");
            q.setParameter("idExecucaoTesteValidacao", idExec);
            q.setParameter("resultado", resultado);

            ativs = q.getResultList();

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
             TesteDBManager.closeConnection();
            return ativs;
        }

    }*/ //findByExecution

    /*public static AtivacaoTesteValidacao findById(Long idActivation) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("AtivacaoTesteValidacao.findById");
        q.setParameter("id", idActivation);

        AtivacaoTesteValidacao execRetornada = null;

        if (q.getResultList().size() > 0) {
            execRetornada = (AtivacaoTesteValidacao) q.getResultList().get(0);
        }
        transaction.commit();
        TesteDBManager.closeConnection();

        return execRetornada;

    }*/


}
