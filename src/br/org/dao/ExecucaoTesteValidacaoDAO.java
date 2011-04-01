package br.org.dao;

import br.org.fdte.persistence.ExecucaoTesteValidacao;
import br.org.fdte.persistence.SuiteTesteValidacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ExecucaoTesteValidacaoDAO {

    private final EntityManager manager;

    public ExecucaoTesteValidacaoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public List<ExecucaoTesteValidacao> getExecucoesTesteValidacaoBySuite(SuiteTesteValidacao suiteId) {

        Query q = this.manager.createNamedQuery("ExecucaoTesteValidacao.findBySuite");
        q.setParameter("idSuite", suiteId);
        return q.getResultList();
    }

    public void delete(ExecucaoTesteValidacao exec) {
      //  ExecucaoTesteValidacao execMerge = this.manager.merge(exec);
        this.manager.remove(exec);
    }

    public void save(ExecucaoTesteValidacao exec) {
        this.manager.persist(exec);
    }

    public ExecucaoTesteValidacao getById(Long id) {
        Query q = this.manager.createNamedQuery("ExecucaoTesteValidacao.findById");
        q.setParameter("id", id);

        ExecucaoTesteValidacao execRetornada = null;

        if (q.getResultList().size() > 0) {
            execRetornada = (ExecucaoTesteValidacao) q.getResultList().get(0);
        }

        return execRetornada;
    }

    public void update(ExecucaoTesteValidacao ex) {
        this.manager.merge(ex);
        this.manager.flush();
    }

    public int getMaxIdGrupoExecPerSuite(SuiteTesteValidacao suiteId) {

        int idEncontrado = 0;

        Query q = this.manager.createNamedQuery("ExecucaoTesteValidacao.findMaxIdGrupoExecPerSuite");
        q.setParameter("idSuite", suiteId.getId());

        List<ExecucaoTesteValidacao> lstExec = q.getResultList();

        if (q.getResultList().size() > 0) {
            idEncontrado = (Integer) q.getResultList().get(0);
        }

        return idEncontrado;
    }

    public List getExecucoesTesteValidacao(SuiteTesteValidacao suiteId) {

        Query q = this.manager.createNamedQuery("ExecucaoTesteValidacao.findBySuite");
        q.setParameter("idSuite", suiteId);

        List<ExecucaoTesteValidacao> lstExec = q.getResultList();
        return lstExec;
    }

    public List getExecucoesTesteValidacaoPerGroup(SuiteTesteValidacao suiteId) {

        Query q = this.manager.createNamedQuery("ExecucaoTesteValidacao.findBySuiteOrderByGroup");
        q.setParameter("idSuite", suiteId);

        List<ExecucaoTesteValidacao> lstExec = q.getResultList();
        return lstExec;

    }
}
