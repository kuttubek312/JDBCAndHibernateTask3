package peaksoft;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
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
        userDao.createUsersTable();
        userDao.saveUser("Медер","Тынычбеков",(byte) 23);
        userDao.saveUser("Куттубек","Жалалов",(byte) 24);
        userDao.saveUser("Айдана","Камчыбекова",(byte) 22);
        userDao.saveUser("Нурсулуу","Алмасова",(byte) 21);

        userDao.removeUserById(2);
        //userDao.dropUsersTable();
        userDao.cleanUsersTable();



    }
}
