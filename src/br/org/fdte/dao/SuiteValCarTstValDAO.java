package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.SuiteTesteValidacao;

import br.org.fdte.persistence.SuiteValidacaoTesteValidacao;
import br.org.fdte.persistence.SuiteValidacaoTesteValidacaoPK;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class SuiteValCarTstValDAO {
    
    public static List getSuiteVal(Long idSuiteTstVal) {
        
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();
      
       Query q = TesteDBManager.entityManager().createNamedQuery("SuiteValidacaoTesteValidacao.findByIdSuiteValidacao");
       q.setParameter("idSuiteValidacao", idSuiteTstVal);

       List<SuiteValidacaoTesteValidacao> lstSuiteValPorCarctTstVal = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstSuiteValPorCarctTstVal;
  }

   public static int save(SuiteValidacaoTesteValidacao svct) {     

       int retorno = 0;

       SuiteValidacaoTesteValidacaoPK suitePK = new SuiteValidacaoTesteValidacaoPK(
               svct.getSuiteTesteValidacao().getId(),
               svct.getCaracterizacaoTesteValidacao().getId());
       
       svct.setSuiteValidacaoTesteValidacaoPK(suitePK);

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();
       TesteDBManager.entityManager().persist(svct);
       transaction.commit();
       TesteDBManager.closeConnection();

       return retorno;
   }

   public static int delete (SuiteTesteValidacao stv) {

        int retorno = 0;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("SuiteValidacaoTesteValidacao.findByIdSuiteValidacao");
        q.setParameter("idSuiteValidacao", stv.getId());

        try {
            if(q.getResultList().size() > 0) {
               Collection<SuiteValidacaoTesteValidacao> lstSuiteVal = q.getResultList();
               Iterator it = lstSuiteVal.iterator();
               while (it.hasNext()) {
                   TesteDBManager.entityManager().remove((SuiteValidacaoTesteValidacao)it.next());
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
