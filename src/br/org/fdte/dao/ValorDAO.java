package br.org.fdte.dao;

import br.connection.db.persistencia.TesteDBManager;
import br.org.fdte.persistence.Valor;
import br.org.fdte.persistence.ClasseEquivalencia;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ValorDAO {

    public static int save(Valor valor) {

        Valor valorSalvo = null;
        int retorno = 0;       

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("Valor.findByValor");
        q.setParameter("valor", valor.getValor());

        //Se já existe instancia de Valor com esse valor
        if (q.getResultList().size() > 0) {
            
            valorSalvo = (Valor)q.getResultList().get(0);

            //se as instâncias com valor encontrado no banco e valor recebido como parâmetro
            //possuem a mesma classe de Equivalencia alem de possuirem o mesmo campo Valor, estamos
            //então fazendo um updade
            if (valor.getIdClasseEquivalencia().getNome().equalsIgnoreCase(
                    valorSalvo.getIdClasseEquivalencia().getNome())) {

                 valorSalvo.setIdClasseEquivalencia(valor.getIdClasseEquivalencia());
                 valorSalvo.setValor(valor.getValor());
                 valorSalvo.setPositivoNegativo(valor.getPositivoNegativo());
                 valorSalvo.setComentario(valor.getComentario());
                 TesteDBManager.entityManager().merge(valorSalvo);
                 retorno = 1;
            }
            else  {
                //estamos fazendo uma inserção em um atributo com o mesmo valor no campo Valor mas,
                //referente a outra classe de equivalencia
                TesteDBManager.entityManager().persist(valor);
            }
        }
        //se não existe nenhuma ocorrência de Valor com esse valor
        else  {
            TesteDBManager.entityManager().persist(valor);
        }
        

        transaction.commit();
        TesteDBManager.closeConnection();

        return retorno;
    }

    public static void delete(String valor, String classeEquivalencia) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("Valor.findByValor");
        q.setParameter("valor", valor);

        if (q.getResultList().size() > 0) {
            int index = 0;
            boolean existeValor = false;
            while (index < q.getResultList().size()) {
                if (((Valor)(q.getResultList().get(index))).getIdClasseEquivalencia().getNome().equalsIgnoreCase(classeEquivalencia))
                     TesteDBManager.entityManager().remove(q.getResultList().get(index));
                index++;
            }
           
        }

       transaction.commit();
       TesteDBManager.closeConnection();
    }

    public static void delete(ClasseEquivalencia ce) {

        EntityTransaction transaction = TesteDBManager.entityManager().getTransaction();
        transaction.begin();

        Query q = TesteDBManager.entityManager().createNamedQuery("ClasseEquivalencia.findByNome");
        q.setParameter("nome", ce.getNome());
        
        if(q.getResultList().size() > 0) {
           Collection<Valor> lstValor ;
           lstValor = ((ClasseEquivalencia)q.getResultList().get(0)).getValorCollection();
           Iterator it = lstValor.iterator();
           while (it.hasNext()) {
               TesteDBManager.entityManager().remove((Valor)it.next());  
           }
        }


       transaction.commit();
       TesteDBManager.closeConnection();

    }

}
