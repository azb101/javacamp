package hibernate.demo;

import org.jooq.User;

import javax.persistence.Persistence;

class HibernateDemo {
    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("SpeakNativeDB");
        var entityManager = entityManagerFactory.createEntityManager();

        try
        {
            //var res = entityManager.createQuery("FROM User").getResultList();

            var res = entityManager.createQuery("FROM Phrase").getResultList();

            System.out.println(res);
        }
        finally {
            entityManagerFactory.close();
            entityManager.close();
        }
    }
}
