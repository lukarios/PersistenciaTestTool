package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.Regra;
import br.org.fdte.persistence.TemplateDocumento;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class DocumentoDAO {

    public static List getAll() {
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findAll");
       List<TemplateDocumento> lstDoc = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       Collections.sort(lstDoc);
       return lstDoc;
    }

    public static TemplateDocumento getDocumento(String name) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

       TemplateDocumento docRetornado = null;

        Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findByNome");
        q.setParameter("nome", name);

       if (q.getResultList().size() > 0) {
          docRetornado = (TemplateDocumento)q.getResultList().get(0);
       }

      transaction.commit();
      TesteDBManager.closeConnection();

      return docRetornado;

    }

     public static TemplateDocumento getDocumento(int id) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

       TemplateDocumento docRetornado = null;

        Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findById");
        q.setParameter("id", id);

       if (q.getResultList().size() > 0) {
          docRetornado = (TemplateDocumento)q.getResultList().get(0);
       }

      transaction.commit();
      TesteDBManager.closeConnection();

      return docRetornado;
    }

    public static int delete (String name) throws RollbackException {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       int retorno = 0;

        Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findByNome");
        q.setParameter("nome", name);

       try {
            if (q.getResultList().size() > 0) {
                 TesteDBManager.entityManager().remove(q.getResultList().get(0));
            }
            transaction.commit();
       }      
       catch(RollbackException e) {
           TesteDBManager.closeConnection();
           throw new RollbackException("Template Documento " + name + " possui vinculo com outras entidades");
       }
       catch(Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
       }

       TesteDBManager.closeConnection();

       return retorno;
    }

    public static int save(TemplateDocumento doc) {

        int retorno = 0;
        TemplateDocumento docSalvo = getDocumento(doc.getNome());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (docSalvo != null) {
            docSalvo.setDirecao(doc.getDirecao());
            docSalvo.setTipoFisico(doc.getTipoFisico());
            docSalvo.setArquivoXsd(doc.getArquivoXsd());
            TesteDBManager.entityManager().merge(docSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(doc);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

     public static int saveById(TemplateDocumento doc) {

        int retorno = 0;
        TemplateDocumento docSalvo = getDocumento(doc.getId().intValue());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (docSalvo != null) {
            docSalvo.setDirecao(doc.getDirecao());
            docSalvo.setTipoFisico(doc.getTipoFisico());
            docSalvo.setArquivoXsd(doc.getArquivoXsd());
            docSalvo.setNome(doc.getNome());
            TesteDBManager.entityManager().merge(docSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(doc);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }


    public static void removeRegras(Long docId) {
         EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();

            transaction.begin();

            Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findById");
            q.setParameter("id", docId);

            if(q.getResultList().size() > 0) {
               Collection<Regra> lstRegra;
               lstRegra = ((TemplateDocumento)q.getResultList().get(0)).getRegraCollection();
               Iterator it = lstRegra.iterator();
               while (it.hasNext()) {
                   TesteDBManager.entityManager().remove((Regra)it.next());
               }
            }
           transaction.commit();
           TesteDBManager.closeConnection();
    }

    public static List getRegras(TemplateDocumento doc) {
        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findById");
        q.setParameter("id", doc.getId());

        List<Regra> lstRegra = new Vector();

        if(q.getResultList().size() > 0) {
           Collection<Regra> collectionRegra = ((TemplateDocumento)q.getResultList().get(0)).getRegraCollection();
           lstRegra.addAll(collectionRegra);
        }

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstRegra;
    }
}
