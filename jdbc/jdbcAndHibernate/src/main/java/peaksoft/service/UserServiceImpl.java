package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;


import java.sql.*;
import java.util.List;

import static peaksoft.util.Util.connect;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoJdbcImpl();

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
      userDao. saveUser(name,lastName,(byte) 21);
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








