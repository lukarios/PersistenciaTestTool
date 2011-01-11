package br.org.fdte.dao;

import br.org.fdte.persistence.ClasseEquivalencia;
import br.connection.db.persistencia.TesteDBManager;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class ClasseEquivalenciaDAO {

    public static int save(ClasseEquivalencia ce) {
        int retorno = 0;
        ClasseEquivalencia ceSalva = getClasseEquivalencia(ce.getNome());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        //Já existe classe de equivalencia com o nome da classe passada por parametro
        if (ceSalva != null) {
            ceSalva.setComentario(ce.getComentario());
            ceSalva.setHeranca(ce.getHeranca());
            ceSalva.setTipo(ce.getTipo());
            ceSalva.setAtributoCollection(ce.getAtributoCollection());
            ceSalva.setClasseEquivalenciaCollection(ce.getClasseEquivalenciaCollection());
            ceSalva.setValorCollection(ce.getValorCollection());
            TesteDBManager.entityManager().merge(ceSalva);
            retorno = 1;
        }
        else {           
           TesteDBManager.entityManager().persist(ce);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;

    }

    public static int saveById(ClasseEquivalencia ce) {

         int retorno = 0;
        ClasseEquivalencia ceSalva = getClasseEquivalencia(ce.getId().intValue());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        //Já existe classe de equivalencia com o id da classe passada por parametro
        if (ceSalva != null) {
            ceSalva.setComentario(ce.getComentario());
            ceSalva.setHeranca(ce.getHeranca());
            ceSalva.setTipo(ce.getTipo());
            ceSalva.setNome(ce.getNome());
            ceSalva.setAtributoCollection(ce.getAtributoCollection());
            ceSalva.setClasseEquivalenciaCollection(ce.getClasseEquivalenciaCollection());
            ceSalva.setValorCollection(ce.getValorCollection());
            TesteDBManager.entityManager().merge(ceSalva);
            retorno = 1;
        }
        else {          
           TesteDBManager.entityManager().persist(ce);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;

    }

    public static ClasseEquivalencia getClasseEquivalencia(String nome) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        ClasseEquivalencia ceRetornada = null;

        Query q = TesteDBManager.entityManager().createNamedQuery("ClasseEquivalencia.findByNome");
        q.setParameter("nome", nome);

       if (q.getResultList().size() > 0) {
           ceRetornada = new ClasseEquivalencia();

           ClasseEquivalencia ceObtida = (ClasseEquivalencia)q.getResultList().get(0);
           ceRetornada = ceObtida;
       }

      transaction.commit();
      TesteDBManager.closeConnection();

      return ceRetornada;
    }

    public static ClasseEquivalencia getClasseEquivalencia (int id) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        ClasseEquivalencia ceRetornada = null;

        Query q = TesteDBManager.entityManager().createNamedQuery("ClasseEquivalencia.findById");
        q.setParameter("id", id);

       if (q.getResultList().size() > 0) {     
           ceRetornada = (ClasseEquivalencia)q.getResultList().get(0);
       }

      transaction.commit();
      TesteDBManager.closeConnection();

      return ceRetornada;
    }

    public static List getAll() {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("ClasseEquivalencia.findAll");

       List<ClasseEquivalencia> lstCE = q.getResultList();
       Collections.sort(lstCE);
       
       transaction.commit();
       TesteDBManager.closeConnection();
     
       return lstCE;

    }

    public static int delete(String nome) throws RollbackException{

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       int retorno = 0;

        Query q = TesteDBManager.entityManager().createNamedQuery("ClasseEquivalencia.findByNome");
        q.setParameter("nome", nome);

       try {
            if (q.getResultList().size() > 0) {
                 TesteDBManager.entityManager().remove(q.getResultList().get(0));
            }
            transaction.commit();
       }
       catch(RollbackException e) {
           TesteDBManager.closeConnection();
           throw new RollbackException("Classe de equivalencia " + nome + " possui vinculo com outras entidades");
       }
       catch(Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
       }
       
       TesteDBManager.closeConnection();

       return retorno;
    }

}
