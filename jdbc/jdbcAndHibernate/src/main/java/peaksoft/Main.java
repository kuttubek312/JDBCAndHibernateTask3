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

//        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
//        userDaoJdbc.createUsersTable();
//        userDaoJdbc.saveUser("Куттубек","Жалалов", (byte) 24);
//        userDaoJdbc.saveUser("Нурсулуу","Алмасова", (byte) 20);
//        userDaoJdbc.saveUser("Еламан","Рахманов", (byte) 21);
//        userDaoJdbc.saveUser("Айдана","Камчыбекова", (byte) 21);


        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        User user1 = new User("Куттубек","Жалалов",(byte)24);
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());

        User user2 = new User("Куттубек","Жалалов",(byte)24);
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());

        User user3 = new User("Куттубек","Жалалов",(byte)24);
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());

        User user4 = new User("Куттубек","Жалалов",(byte)24);
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());


        List<User> userList = userService.getAllUsers();
        for (User user:userList) {
            System.out.println(user);
        }

        userService.removeUserById(1);
        userService.dropUsersTable();
    }
}
