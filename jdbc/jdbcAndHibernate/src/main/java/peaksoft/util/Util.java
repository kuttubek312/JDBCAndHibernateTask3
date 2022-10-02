package peaksoft.util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.dao.UserDao;
import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.lang.AutoCloseable;

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


    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "-"); //  бд  пока кошо елекмин
                settings.put(Environment.URL,"-"); //
                settings.put(Environment.USER,"postgres"); //  login или postgres
                settings.put(Environment.PASS,"kutu013kg"); // корень пока не знаю что это
                settings.put(Environment.DIALECT,"-"); // диалект

                settings.put(Environment.SHOW_SQL,"true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"threes");

                settings.put(Environment.HBM2DDL_AUTO,"creat");


                configuration.setProperties(settings);

                configuration.addAnnotatedClass(UserDao.class);

                ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                        sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) serviceRegistry);
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

