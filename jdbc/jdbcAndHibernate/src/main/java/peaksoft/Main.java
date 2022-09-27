package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {



        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

       // userDaoJdbc.createUsersTable();

    //   userDaoJdbc.saveUser("Куттубек","Жалалов",(byte) 24);
//        userDaoJdbc.saveUser("Айдана","Камчыбекова",(byte) 23);
//        userDaoJdbc.saveUser("Еламан","Рахманов",(byte) 21);
//        userDaoJdbc.saveUser("Нурсулуу","Алмасова",(byte) 20);
//
       // userDaoJdbc.dropUsersTable();
        userDaoJdbc.removeUserById(2);
//        userDaoJdbc.cleanUsersTable();


        List<User> userList = userDaoJdbc.getAllUsers();
        System.out.println(userList);
    }
}
