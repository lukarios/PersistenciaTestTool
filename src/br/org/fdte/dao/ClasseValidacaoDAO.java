package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.ClasseValidacao;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ClasseValidacaoDAO {

    public static List getAll() {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("ClasseValidacao.findAll");

       List<ClasseValidacao> lstCV = q.getResultList();


       transaction.commit();
       TesteDBManager.closeConnection();

       return lstCV;

    }

}
