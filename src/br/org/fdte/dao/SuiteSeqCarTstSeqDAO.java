package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.SuiteSequenciaPorCaracterizacaoTesteSequencia;
import br.org.fdte.persistence.SuiteSequenciaPorCaracterizacaoTesteSequenciaPK;
import br.org.fdte.persistence.SuiteTesteSequencia;
import br.org.fdte.persistence.SuiteTesteValidacao;

import br.org.fdte.persistence.SuiteValidacaoTesteValidacao;
import br.org.fdte.persistence.SuiteValidacaoTesteValidacaoPK;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class SuiteSeqCarTstSeqDAO {
    
    public static List getSuiteSeq(Long idSuiteTstSeq) {
        
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();
      
       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteSequenciaPorCaracterizacaoTesteSequencia.findByIdSuiteSequencia");
       q.setParameter("idSuiteSequencia", idSuiteTstSeq);

       List<SuiteSequenciaPorCaracterizacaoTesteSequencia> lstSuiteSeqPorCarctTstSeq = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstSuiteSeqPorCarctTstSeq;
  }

   public static int save(SuiteSequenciaPorCaracterizacaoTesteSequencia svct) {

       int retorno = 0;

       SuiteSequenciaPorCaracterizacaoTesteSequenciaPK suitePK = new SuiteSequenciaPorCaracterizacaoTesteSequenciaPK(
               svct.getSuiteTesteSequencia().getId(),
               svct.getCaracterizacaoTesteSequencia().getId());
       
       svct.setSuiteSequenciaPorCaracterizacaoTesteSequenciaPK(suitePK);

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();
       TesteDBManager.entityManager().persist(svct);
       transaction.commit();
       TesteDBManager.closeConnection();

       return retorno;
   }

   public static int delete (SuiteTesteSequencia sts) {

        int retorno = 0;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("SuiteSequenciaPorCaracterizacaoTesteSequencia.findByIdSuiteSequencia");
        q.setParameter("idSuiteSequencia", sts.getId());

        try {
            if(q.getResultList().size() > 0) {
               Collection<SuiteSequenciaPorCaracterizacaoTesteSequencia> lstSuiteSeq = q.getResultList();
               Iterator it = lstSuiteSeq.iterator();
               while (it.hasNext()) {
                   TesteDBManager.entityManager().remove((SuiteSequenciaPorCaracterizacaoTesteSequencia)it.next());
               }
            }
             transaction.commit();
        }
        catch(Exception e) {
            retorno = -1;
            e.getMessage();
        }
       TesteDBManager.closeConnection();
       return retorno;
    }
}
