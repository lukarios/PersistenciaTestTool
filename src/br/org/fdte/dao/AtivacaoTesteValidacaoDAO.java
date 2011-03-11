package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.AtivacaoTesteValidacao;
import br.org.fdte.persistence.CaracterizacaoTesteValidacao;
import br.org.fdte.persistence.ExecucaoTesteValidacao;
import br.org.fdte.persistence.SuiteTesteValidacao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class AtivacaoTesteValidacaoDAO {

    public static int deleteByExecution(ExecucaoTesteValidacao idExecution) throws RollbackException {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        int retorno = 0;

        try {
            Query q = TesteDBManager.entityManager().createNamedQuery("AtivacaoTesteValidacao.deleteByExecution");
            q.setParameter("execution", idExecution);
        } catch (Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

    public static int save(AtivacaoTesteValidacao ativ) {

        int retorno = 0;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (ativ.getId() == null) {
            TesteDBManager.entityManager().persist(ativ);
        } else {
            TesteDBManager.entityManager().merge(ativ);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

    public static Collection<AtivacaoTesteValidacao> findGoldenActivations(CaracterizacaoTesteValidacao ctv, SuiteTesteValidacao suite) throws Exception {

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

    public static List<AtivacaoTesteValidacao> findByExecution(ExecucaoTesteValidacao idExec, String resultado) {

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

    } //findByExecution
}
