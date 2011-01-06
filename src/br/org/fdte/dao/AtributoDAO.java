package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.TemplateDocumento;
import br.org.fdte.persistence.Atributo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class AtributoDAO {

    public static void delete(TemplateDocumento doc) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();

            transaction.begin();

            Query q = TesteDBManager.entityManager().createNamedQuery("TemplateDocumento.findByNome");
            q.setParameter("nome", doc.getNome());

            if(q.getResultList().size() > 0) {
               Collection<Atributo> lstAtributo;
               lstAtributo = ((TemplateDocumento)q.getResultList().get(0)).getAtributoCollection();
               Iterator it = lstAtributo.iterator();
               while (it.hasNext()) {
                   TesteDBManager.entityManager().remove((Atributo)it.next());
               }
            }

           transaction.commit();
           TesteDBManager.closeConnection();
    }

    public static void delete(String atributo, String nomeDocumento) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("Atributo.findByTag");
        q.setParameter("tag", atributo);

        if (q.getResultList().size() > 0) {
            int index = 0;
            while (index < q.getResultList().size()) {
                if (((Atributo)(q.getResultList().get(index))).getIdClasseEquivalencia().getNome().equalsIgnoreCase(nomeDocumento))
                   TesteDBManager.entityManager().remove(q.getResultList().get(0));
                index++;
            }
        }

       transaction.commit();
       TesteDBManager.closeConnection();
    }

    public static int save(Atributo atributo) {
        int retorno = 0;
        Atributo atributoSalvo = null;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("Atributo.findByTag");
        q.setParameter("tag", atributo.getTag());
      
        if (q.getResultList().size() > 0) {
            atributoSalvo = (Atributo)q.getResultList().get(0);
        
            if (atributo.getIdTemplateDocumento().getNome().equalsIgnoreCase(                
                atributoSalvo.getIdTemplateDocumento().getNome())) {
                atributoSalvo.setIdClasseEquivalencia(atributo.getIdClasseEquivalencia());
                atributoSalvo.setIdTemplateDocumento(atributo.getIdTemplateDocumento());
                atributoSalvo.setNumeroMaximoOcorrencias(atributo.getNumeroMaximoOcorrencias());
                atributoSalvo.setOpcional(atributo.getOpcional());
                TesteDBManager.entityManager().merge(atributo);
                retorno = 1;
            }
            else
              TesteDBManager.entityManager().merge(atributo);
        }
        else
            TesteDBManager.entityManager().persist(atributo);

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

    public static List getAll() {
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("Atributo.findAll");

       List<Atributo> atributos = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return atributos;
    }

    public static Atributo get(Long id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("Atributo.findById");
       q.setParameter("id", id);

       Atributo atributoRetornado = (Atributo)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return atributoRetornado;

    }

}
