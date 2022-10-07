package peaksoft;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        /**
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

        userDaoJdbc.createUsersTable();

        userDaoJdbc.saveUser("Куттубек", "Жалалов", (byte) 24);
        userDaoJdbc.saveUser("Айдана", "Камчыбекова", (byte) 23);
        userDaoJdbc.saveUser("Еламан", "Рахманов", (byte) 21);
        userDaoJdbc.saveUser("Нурсулуу", "Алмасова", (byte) 20);

        userDaoJdbc.dropUsersTable();
        userDaoJdbc.removeUserById(2);
        userDaoJdbc.cleanUsersTable();


        List<User> userList = userDaoJdbc.getAllUsers();
        System.out.println(userList);
         **/

        UserDao userDao = new UserDaoHibernateImpl();

       // userDao.createUsersTable();
        User user = new User("Медер","Тынычбеков",(byte) 23);
        userDao.saveUser(user.getName(),user.getLastName(),user.getAge());


        User user2 = new User("Куттубек","Жалалов",(byte) 24);
        userDao.saveUser(user2.getName(),user2.getLastName(),user2.getAge());

        User user3 = new User("Нурсулуу","Алмасова",(byte) 21);
        userDao.saveUser(user3.getName(),user3.getLastName(),user3.getAge());


    }
}
