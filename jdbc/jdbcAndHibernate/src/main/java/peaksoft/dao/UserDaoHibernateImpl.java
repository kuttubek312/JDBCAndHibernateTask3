package peaksoft.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.Util;
import java.util.ArrayList;
import java.util.List;
import static peaksoft.util.Util.sessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    //SessionFactory session = new Util().getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS User" +
                    "  id       BIGINT       PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "  name     VARCHAR(250) DEFAULT NULL," +
                    "  lastname VARCHAR(250) DEFAULT NULL," +
                    "  age      TINYINT      DEFAULT NULL)";
            session.save(sql);
//            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("hibernate таблицасы тузулду");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery("DROP TABLE IF EXISTS User");
            session.getTransaction().commit();
            session.close();
            System.out.println("hibernate уделение болду");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            session.close();
            System.out.println("hibernate маалымат кошулду");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
//            session.delete(session.get(User.class, id));//1й вариант
            session.createQuery("delete User where id = :id")
                    .setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("hibernate айди мн очуруу");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            userList = session.createQuery("from User order by name").list();
            session.getTransaction().commit();
            session.close();
            System.out.println("hibernate >>>");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try {Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("hibernate чистка болду");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
