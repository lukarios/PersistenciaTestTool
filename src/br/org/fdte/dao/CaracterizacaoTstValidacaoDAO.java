package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.CaracterizacaoTesteValidacao;
import br.org.fdte.persistence.Especificos;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class CaracterizacaoTstValidacaoDAO {

    public static List getAll() {
       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteValidacao.findAll");

       List<CaracterizacaoTesteValidacao> lstTV = q.getResultList();

       transaction.commit();
       TesteDBManager.closeConnection();

       Collections.sort(lstTV);
       return lstTV;
    }

    public static CaracterizacaoTesteValidacao getCaracterizacaoTesteValidacao(String nome) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteValidacao.findByNome");
       q.setParameter("nome", nome);

       CaracterizacaoTesteValidacao caractTstVal = null;

       if (q.getResultList().size() > 0)
           caractTstVal = (CaracterizacaoTesteValidacao)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return caractTstVal;
    }

     public static CaracterizacaoTesteValidacao getCaracterizacaoTesteValidacao(int id) {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteValidacao.findById");
       q.setParameter("id", id);

       CaracterizacaoTesteValidacao caractTstVal = null;

       if (q.getResultList().size() > 0)
           caractTstVal = (CaracterizacaoTesteValidacao)q.getResultList().get(0);

       transaction.commit();
       TesteDBManager.closeConnection();

       return caractTstVal;
    }

    public static int save(CaracterizacaoTesteValidacao tstVal) {

        int retorno = 0;
        CaracterizacaoTesteValidacao tstValidacaoSalvo = getCaracterizacaoTesteValidacao(tstVal.getNome());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (tstValidacaoSalvo != null) {
            tstValidacaoSalvo.setDocumentoEntrada(tstVal.getDocumentoEntrada());
            tstValidacaoSalvo.setComentario(tstVal.getComentario());
            tstValidacaoSalvo.setClasseValidacaoSaidaNegativa(tstVal.getClasseValidacaoSaidaNegativa());
            tstValidacaoSalvo.setClasseValidacaoSaidaPositiva(tstVal.getClasseValidacaoSaidaPositiva());
            tstValidacaoSalvo.setDocumentoSaidaPositiva(tstVal.getDocumentoSaidaPositiva());
            tstValidacaoSalvo.setDocumentoSaidaNegativa(tstVal.getDocumentoSaidaNegativa());
            tstValidacaoSalvo.setCasosPositivos(tstVal.getCasosPositivos());
            tstValidacaoSalvo.setCasosNegativos(tstVal.getCasosNegativos());
            tstValidacaoSalvo.setCasosOpcionais(tstVal.getCasosOpcionais());
            tstValidacaoSalvo.setCasosRepeticoes(tstVal.getCasosRepeticoes());
            TesteDBManager.entityManager().merge(tstValidacaoSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(tstVal);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

    public static int saveById(CaracterizacaoTesteValidacao tstVal) {

        int retorno = 0;
        CaracterizacaoTesteValidacao tstValidacaoSalvo = getCaracterizacaoTesteValidacao(tstVal.getId().intValue());

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        if (tstValidacaoSalvo != null) {
            tstValidacaoSalvo.setDocumentoEntrada(tstVal.getDocumentoEntrada());
            tstValidacaoSalvo.setClasseValidacaoSaidaNegativa(tstVal.getClasseValidacaoSaidaNegativa());
            tstValidacaoSalvo.setClasseValidacaoSaidaPositiva(tstVal.getClasseValidacaoSaidaPositiva());
            tstValidacaoSalvo.setNome(tstVal.getNome());
            TesteDBManager.entityManager().merge(tstValidacaoSalvo);
            retorno = 1;
        }
        else {
            TesteDBManager.entityManager().persist(tstVal);
        }

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }


    public static int delete (String name) throws RollbackException {

       EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
       transaction.begin();

       int retorno = 0;

       Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteValidacao.findByNome");
       q.setParameter("nome", name);


       try {
            if (q.getResultList().size() > 0) {
                 TesteDBManager.entityManager().remove(q.getResultList().get(0));
            }
            transaction.commit();
       }
       catch(RollbackException e) {
           TesteDBManager.closeConnection();
           throw new RollbackException("Caracterizacao Teste Validação " + name + " possui vinculo com outras entidades");
       }
       catch(Exception e) {
            retorno = -1;
            System.out.println(e.getMessage());
       }

       TesteDBManager.closeConnection();

       return retorno;
    }

    
     public static void removeEspecificos(Long tstValId) {

         EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();

            transaction.begin();

            Query q = TesteDBManager.entityManager().createNamedQuery("CaracterizacaoTesteValidacao.findById");
            q.setParameter("id", tstValId);

            if(q.getResultList().size() > 0) {
               Collection<Especificos> lstEspecifico;
               lstEspecifico = ((CaracterizacaoTesteValidacao)q.getResultList().get(0)).getEspecificosCollection();
               Iterator it = lstEspecifico.iterator();
               while (it.hasNext()) {
                   TesteDBManager.entityManager().remove((Especificos)it.next());
               }
            }

           transaction.commit();
           TesteDBManager.closeConnection();

    }

}
