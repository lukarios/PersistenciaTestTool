package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.Especificos;
import javax.persistence.EntityTransaction;

public class EspecificoDAO {

    public static int save(Especificos especifico) {

        Especificos especificoSalvo = null;
        int retorno = 0;

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        TesteDBManager.entityManager().persist(especifico);

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;

    }

}
