package br.org.servicos;

import br.org.dao.AtributoDAO;
import br.org.dao.DocumentoDAO;
import br.org.dao.RegraDAO;

import br.org.fdte.persistence.Atributo;
import br.org.fdte.persistence.Regra;
import br.org.fdte.persistence.TemplateDocumento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;

public class DocumentoServico {

    EntityManager manager;

    public boolean save(TemplateDocumento doc) {

        boolean isNewDocument = false;

        this.manager = DBManager.openManager();

        DocumentoDAO docDao = new DocumentoDAO(manager);
        AtributoDAO attDao = new AtributoDAO(manager);

        EntityTransaction et = this.manager.getTransaction();
        try {
            et.begin();

            TemplateDocumento docObtido = docDao.getByName(doc.getNome());

            //não encontrado documento pelo nome
            if (docObtido == null) {
                if (doc.getId() == null) {
                    docDao.save(doc);
                    isNewDocument = true;

                    //lrb 25/02/2011
                    //salvar as regras que foram vinculadas ao documento criado,
                    //pois pode-se estar copiando um documento existente
                    /*RegraDAO regraDao = new RegraDAO(manager);
                    for (Regra regra : doc.getRegraCollection()) {
                        regra.setIdTemplateDocumento(doc);
                        regraDao.save(regra);
                    }*/
                } //o documento possui id isto é, ele já existe
                //somente o seu nome foi alterado
                else {
                    docDao.update(doc);
                }

            } else {
                docObtido.setArquivoXsd(doc.getArquivoXsd());
                docObtido.setDirecao(doc.getDirecao());                
                docObtido.setTipoFisico(doc.getTipoFisico());

                for (Atributo att : docObtido.getAtributoCollection()) {
                    attDao.delete(att);
                }

                this.manager.flush();

                for (Atributo att : doc.getAtributoCollection()) {
                    att.setIdTemplateDocumento(docObtido);
                    attDao.save(att);
                }

                docObtido.setAtributoCollection(doc.getAtributoCollection());
                
            }
            et.commit();
        } catch (Exception ex) {
            et.rollback();
            System.out.println(ex.getMessage());
        }
        return isNewDocument;
    }

    public void delete(String docName) {

        try {

            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            DocumentoDAO docDao = new DocumentoDAO(manager);
            AtributoDAO atributoDao = new AtributoDAO(manager);
            RegraDAO regraDao = new RegraDAO(manager);
            TemplateDocumento doc = docDao.getByName(docName);

            for (Regra regra : doc.getRegraCollection()) {
                regraDao.delete(regra);
            }

            for (Atributo att : doc.getAtributoCollection()) {
                atributoDao.delete(att);
            }

            docDao.delete(doc);

            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            this.manager.getTransaction().rollback();
        }
    }

    public TemplateDocumento getByName(String nome) {

        TemplateDocumento doc = null;

        try {
            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            DocumentoDAO docDao = new DocumentoDAO(manager);

            doc = docDao.getByName(nome);

            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            System.out.println(excpt.getMessage());
            this.manager.getTransaction().rollback();
        } finally {
            return doc;
        }

    }

    public List<TemplateDocumento> getAll() {

        List<TemplateDocumento> lstDoc = null;

        try {
            this.manager = DBManager.openManager();
            this.manager.getTransaction().begin();

            DocumentoDAO docDao = new DocumentoDAO(manager);

            lstDoc = docDao.getAll();

            this.manager.getTransaction().commit();
        } catch (Exception excpt) {
            this.manager.getTransaction().rollback();
        } finally {
            return lstDoc;
        }
    }
}
