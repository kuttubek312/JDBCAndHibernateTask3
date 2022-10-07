package peaksoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("table created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Успешное удаление всех пользователей");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            session.close();
            System.out.println("Успешное сохранение пользователей ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSession().openSession();
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("delete from  users where id = ?").executeUpdate();
            transaction.commit();
            System.out.println(id + " " + "удален пользователь с id");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public List<User> getAllUsers() {
        try {
            List<User> userList;
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            userList = session.createQuery("from User").list();
            session.getTransaction().commit();
            session.close();
            return userList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Очищено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}