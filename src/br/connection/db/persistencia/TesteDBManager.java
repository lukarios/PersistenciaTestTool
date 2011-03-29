package br.connection.db.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteDBManager {   

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public TesteDBManager() {
        if (emf == null)           
            emf =  Persistence.createEntityManagerFactory("TestToolPU");

        if (em == null)
            em = emf.createEntityManager();
    }


    public static void closeConnection() {
       em.close();
       emf.close(); //close at application end

       em = null;
       emf = null;
    }


    static public EntityManager entityManager() {
        if (emf == null)
           emf =  Persistence.createEntityManagerFactory("TestToolPU");

        if (em == null)
            em = emf.createEntityManager();

        return em;
    }   
    

public static void main(String[] args) throws ClassNotFoundException {
    TesteDBManager testDB = new TesteDBManager();
    testDB.entityManager();
}

}



