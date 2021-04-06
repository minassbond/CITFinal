package PokedexDB.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {

    private static final SessionFactory session = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            ServiceRegistry servReg = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(servReg).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return session;
    }

    public static void shutdown() {

        getSessionFactory().close();
    }
}
