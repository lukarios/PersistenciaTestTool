package br.org.dao;

import br.org.fdte.persistence.Especificos;
import javax.persistence.EntityManager;

public class EspecificoDAO {

    private final EntityManager manager;

    public EspecificoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Especificos especifico) {
            this.manager.persist(especifico);
    }

    public void delete(Especificos especifico) {
        this.manager.remove(especifico);
    }
}
