package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.ExecucaoTesteValidacao;
import br.org.fdte.persistence.SuiteTesteValidacao;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class ExecucaoTesteValidacaoDAO {

    /*public static int getMaxIdGrupoExecPerSuite(SuiteTesteValidacao suiteId) {

        int idEncontrado = 0;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findMaxIdGrupoExecPerSuite");
        q.setParameter("idSuite", suiteId.getId());

        if (q.getResultList().size() > 0) {
            idEncontrado = (Integer) q.getResultList().get(0);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return idEncontrado;
    }*/

    /*public static List getAll() {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findAll");

        List<ExecucaoTesteValidacao> lstExec = q.getResultList();

        transaction.commit();
        TesteDBManager.closeConnection();

        return lstExec;
    }*/

/*    public static ExecucaoTesteValidacao getExecucaoTesteValidacao(int id) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findById");
        q.setParameter("id", id);

        ExecucaoTesteValidacao execRetornada = null;

        if (q.getResultList().size() > 0) {
            execRetornada = (ExecucaoTesteValidacao) q.getResultList().get(0);
        }
        transaction.commit();
        TesteDBManager.closeConnection();

        return execRetornada;
    }*/

    /*public static List getExecucoesTesteValidacao(SuiteTesteValidacao suiteId) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findBySuite");
        q.setParameter("idSuite", suiteId);

        List<ExecucaoTesteValidacao> lstExec = q.getResultList();

        transaction.commit();
        TesteDBManager.closeConnection();

        return lstExec;

    }*/

   public static List getExecucoesTesteValidacaoPerGroup(SuiteTesteValidacao suiteId) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findBySuiteOrderByGroup");
        q.setParameter("idSuite", suiteId);

        List<ExecucaoTesteValidacao> lstExec = q.getResultList();

        transaction.commit();
        TesteDBManager.closeConnection();

        return lstExec;

    }

   /* public static int delete(int id) throws RollbackException {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        int retorno = 0;

        Query q = TesteDBManager.entityManager().createNamedQuery("ExecucaoTesteValidacao.findById");
        q.setParameter("id", id);

        try {
            if (q.getResultList().size() > 0) {
                TesteDBManager.entityManager().remove(q.getResultList().get(0));
            }
            transaction.commit();
        } catch (RollbackException e) {
            TesteDBManager.closeConnection();
            throw new RollbackException("Execução de Teste Validação " + id + " possui vinculo com outras entidades");
        } catch (Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
        }

        TesteDBManager.closeConnection();

        return retorno;
    }*/

  /*  public static int save(ExecucaoTesteValidacao exec) {
        int retorno = 0;

        //if (exec.getId() != null) {
        //Long idNulo = 0L;
        //exec.setId(idNulo);
        //}

        //ExecucaoTesteValidacao execSalva = getExecucaoTesteValidacao(exec.getId().intValue());

        EntityTransaction transaction;


        if (exec.getId() == null) {
            transaction = TesteDBManager.entityManager().getTransaction();
            transaction.begin();
            TesteDBManager.entityManager().persist(exec);
        } else {
            ExecucaoTesteValidacao execSalva = getExecucaoTesteValidacao(exec.getId().intValue());
            execSalva.setCasosFalha(exec.getCasosFalha());
            execSalva.setCasosSucesso(exec.getCasosSucesso());
            execSalva.setCasosTimeout(exec.getCasosTimeout());
            execSalva.setComentario(exec.getComentario());
            execSalva.setInicio(exec.getInicio());
            execSalva.setTermino(exec.getTermino());
            transaction = TesteDBManager.entityManager().getTransaction();
            transaction.begin();
            TesteDBManager.entityManager().merge(execSalva);
            retorno = 1;
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }*/

   
}
