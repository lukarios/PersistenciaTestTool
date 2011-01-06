package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.CaracterizacaoTesteSequencia;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class CaracterizacaoTstSequenciaDAO {

    public static List getAll() {
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteSequencia.findAll");

       List<CaracterizacaoTesteSequencia> lstTV = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstTV;
    }

    public static CaracterizacaoTesteSequencia getCaracterizacaoTesteSequencia(String nome) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteSequencia.findByNome");
       q.setParameter("nome", nome);

       CaracterizacaoTesteSequencia caractTstSeq = null;

       if (q.getResultList().size() > 0)
           caractTstSeq = (CaracterizacaoTesteSequencia)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return caractTstSeq;
    }

     public static CaracterizacaoTesteSequencia getCaracterizacaoTesteSequencia(int id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteSequencia.findById");
       q.setParameter("id", id);

       CaracterizacaoTesteSequencia caractTstSeq = null;

       if (q.getResultList().size() > 0)
           caractTstSeq = (CaracterizacaoTesteSequencia)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return caractTstSeq;
    }

    public static int save(CaracterizacaoTesteSequencia tstSeq) {
        int retorno = 0;
        CaracterizacaoTesteSequencia tstSalvo = getCaracterizacaoTesteSequencia(tstSeq.getNome());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (tstSalvo != null) {
            tstSalvo.setComentario(tstSeq.getComentario());
            TesteDBManager.entityManager().merge(tstSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(tstSeq);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }


    public static int delete (String name) throws RollbackException {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       int retorno = 0;

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteVerificacao.findByNome");
       q.setParameter("nome", name);


       try {
            if (q.getResultList().size() > 0) {
                 TesteDBManager.entityManager().remove(q.getResultList().get(0));
            }
            transaction.commit();
       }
       catch(RollbackException e) {
           TesteDBManager.closeConnection();
           throw e;
       }
       catch(Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
       }

       TesteDBManager.closeConnection();

       return retorno;
    }




}

