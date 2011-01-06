package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.org.fdte.persistence.RelacaoEntao;

public class RelacaoEntaoDAO {

      public static List getAll() {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("RelacaoEntao.findAll");

       List<RelacaoEntao> lstRelacao = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstRelacao;

    }

    public static RelacaoEntao get(Long id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("RelacaoEntao.findById");
       q.setParameter("id", id);

       RelacaoEntao relacaoEntaoRetornada = (RelacaoEntao)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return relacaoEntaoRetornada;
       
    }

}
