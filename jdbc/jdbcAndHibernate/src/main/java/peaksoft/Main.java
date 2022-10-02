package peaksoft;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import java.sql.SQLException;
import java.util.List;

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

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

//        userDaoHibernate.saveUser("Куттубек","Жалалов",(byte) 24);
//        userDaoHibernate.saveUser("Медер","Тынычбеков",(byte) 23);
//        userDaoHibernate.saveUser("Айдана","Камчыбекова",(byte) 22);
//        userDaoHibernate.saveUser("Нурсулуу","Алмасова",(byte) 21);

//        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.removeUserById(3);
//        userDaoHibernate.cleanUsersTable();

    }
}
