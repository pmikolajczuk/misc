package pl.mikolaj.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setId(104);
        a1.setName("Jane");
        a1.setTech("Cloud");

        Configuration config = new Configuration();
        config.addAnnotatedClass(Alien.class);
        config.configure();
        try (SessionFactory sf = config.buildSessionFactory()) {
            try (Session session = sf.openSession()) {
                session.beginTransaction();
                session.persist(a1);
//                Alien a2 = session.find(Alien.class, 103);
//                System.out.println(a2);

//                session.merge(a1);
//                session.remove(a2);

                session.getTransaction().commit();

            }
        }
    }
}