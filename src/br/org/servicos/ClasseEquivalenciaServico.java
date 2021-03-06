package br.org.servicos;

import br.org.dao.ClasseEquivalenciaDAO;
import br.org.dao.ValorDAO;
import br.org.fdte.persistence.ClasseEquivalencia;
import br.org.fdte.persistence.Valor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class ClasseEquivalenciaServico implements ServiceInterface {

    EntityManager manager;

    @Override
    public List<Object> getAll() {

        List<Object> lstCE = new ArrayList<Object>();

        try {
            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            ClasseEquivalenciaDAO ceDao = new ClasseEquivalenciaDAO(manager);

            for (ClasseEquivalencia ce : ceDao.getAll()) {
                lstCE.add(ce);
            }           

            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            this.manager.getTransaction().rollback();
        } finally {
            return lstCE;
        }
    }

    @Override
    public ClasseEquivalencia getByName(String nomeCE) {

        ClasseEquivalencia ce = null;

        try {
            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            ClasseEquivalenciaDAO ceDao = new ClasseEquivalenciaDAO(manager);
            ce = ceDao.getByName(nomeCE);

            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            this.manager.getTransaction().rollback();
        } finally {            
            return ce;
        }

    }

    public ClasseEquivalencia getById(int id) {

        ClasseEquivalencia ce = null;

        try {
            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            ClasseEquivalenciaDAO ceDao = new ClasseEquivalenciaDAO(manager);
            ce = ceDao.getById(id);

            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            this.manager.getTransaction().rollback();
        } finally {
            return ce;
        }


    }

    @Override
    public boolean save(Object obj) {

        if ( !(obj instanceof ClasseEquivalencia)) {
            return false;
        }

        ClasseEquivalencia ce = (ClasseEquivalencia)obj;
        boolean isNewCE = false;

        try {

            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            ClasseEquivalenciaDAO ceDao = new ClasseEquivalenciaDAO(manager);
            ClasseEquivalencia ceObtida = ceDao.getByName(ce.getNome());

            //não encontrada classe de equivalencia pelo nome
            if (ceObtida == null) {
                if (ce.getId() == null) {
                    ceDao.save(ce);
                    isNewCE = true;
                }
                //a classe euivalencia possui id isto é, ela já existe
                //somente o seu nome foi alterado
                else {
                    ceDao.update(ce);
                }

            } else {

                ceObtida.setComentario(ce.getComentario());
                ceObtida.setHeranca(ce.getHeranca());
                ceObtida.setTipo(ce.getTipo());

                ValorDAO valorDAO = new ValorDAO(manager);
                for (Valor valor : ceObtida.getValorCollection()) {
                    valorDAO.delete(valor);
                }

                for (Valor valor : ce.getValorCollection()) {
                    valor.setIdClasseEquivalencia(ceObtida);
                    valorDAO.save(valor);
                }

                ceObtida.setValorCollection(ce.getValorCollection());
                ceDao.update(ceObtida);
            }


            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            System.out.println(excpt.getMessage());
            this.manager.getTransaction().rollback();
        }

        return isNewCE;
    }

    @Override
    public void delete(String nomeCE) {
        try {

            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            ClasseEquivalenciaDAO ceDao = new ClasseEquivalenciaDAO(manager);
            ClasseEquivalencia ce = ceDao.getByName(nomeCE);

            ValorDAO valorDao = new ValorDAO(manager);
            for (Valor valor : ce.getValorCollection()) {
                valorDao.delete(valor);
            }

            ceDao.delete(ce);


            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            System.out.println(excpt.getMessage());
            this.manager.getTransaction().rollback();
        }
    }   


}
