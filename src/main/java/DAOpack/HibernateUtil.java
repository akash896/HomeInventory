package DAOpack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        // code to load Hibernate Session factory
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return sessionFactory;
    }

    public static Session getSession(){
        Session session;
        if(sessionFactory!=null){
            session = sessionFactory.openSession();
            session.beginTransaction();
        }
        else{
            session = getSessionFactory().openSession();
            session.beginTransaction();
        }
        return session;
    }

}
