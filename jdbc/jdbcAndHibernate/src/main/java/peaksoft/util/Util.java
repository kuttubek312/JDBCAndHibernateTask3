package peaksoft.util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД
    public static final String url = "jdbc:postgresql://localhost:5432/home_work_6";
    public static final String user = "postgres";
    public static final String password = "kutu013kg";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect болду postgres серверге кошулду");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/home_work_6");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "kutu013kg");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "validate");
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(peaksoft.model.User.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSession() {
        return buildSessionFactory();
    }
    public static void shutDown() {
        getSession().close();
    }
}

