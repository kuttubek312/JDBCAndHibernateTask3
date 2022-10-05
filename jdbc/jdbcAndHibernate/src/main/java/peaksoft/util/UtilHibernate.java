package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.util.Properties;

public class UtilHibernate {
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL,"jdbc:postgresql://localhost:5432/home_work_6");
                settings.put(Environment.USER,"postgres");
                settings.put(Environment.PASS,"kutu013kg");
                settings.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL,"true");
                settings.put(Environment.HBM2DDL_AUTO,"create");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void shutDown(){
        getSessionFactory().close();
    }

}