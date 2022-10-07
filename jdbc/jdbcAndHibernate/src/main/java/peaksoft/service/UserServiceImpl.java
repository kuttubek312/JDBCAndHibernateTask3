package peaksoft.service;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {

   // private UserDao userDao = new UserDaoJdbcImpl();
    private  UserDao userDao = new UserDaoHibernateImpl();

    public UserServiceImpl() {

    }

    @Override
    public void createUsersTable() throws SQLException {
      userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
      userDao. saveUser(name,lastName,age);
    }

    @Override
    public void removeUserById(long id) {
       userDao. removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}








