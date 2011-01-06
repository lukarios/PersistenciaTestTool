package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.org.fdte.persistence.TipoClasseEquivalencia;

public class TipoClasseEquivalenciaDAO {

    public static List getAll() {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("TipoClasseEquivalencia.findAll");

       List<TipoClasseEquivalencia> lstTipoCE = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       return lstTipoCE;
    }

    public static TipoClasseEquivalencia getTipoClasseEquivalencia(String tipoCE) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       TipoClasseEquivalencia tipoClasseEquivalencia = null;

       Query q = TesteDBManager.entityManager().createNamedQuery("TipoClasseEquivalencia.findByTipoClasseEquivalencia");
       q.setParameter("tipoClasseEquivalencia", tipoCE);

       if (q.getResultList().size() > 0)
           tipoClasseEquivalencia = (TipoClasseEquivalencia)q.getResultList().get(0);


       transaction.commit();
       TesteDBManager.closeConnection();

       return tipoClasseEquivalencia;

    }

}
