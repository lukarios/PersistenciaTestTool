package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import javax.persistence.EntityTransaction;
import br.org.fdte.persistence.RelacaoSe;
import java.util.List;
import javax.persistence.Query;

public class RelacaoSeDAO {

    public static List getAll() {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("RelacaoSe.findAll");

       List<RelacaoSe> lstRelacaoSe = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstRelacaoSe;

    }

    public static RelacaoSe get(Long id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("RelacaoSe.findById");
       q.setParameter("id", id);

       RelacaoSe relacaoSeRetornada = (RelacaoSe)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return relacaoSeRetornada;


    }

}
