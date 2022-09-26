package peaksoft.dao;

import peaksoft.model.User;

import java.sql.*;

import java.util.List;

import static peaksoft.util.Util.connect;


public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable()  {
        String SQL = "CREATE TABLE user" +
                "(name VARCHAR (50)," +
                "lastName VARCHAR (60)," +
                "age INTEGER NOT NULL)";
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.executeUpdate(SQL);
            System.out.println("таблица успешно тузулду");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void dropUsersTable(){
             String DROP_SQL = "DROP TABLE user";
        try (Connection connect = connect();
             Statement statement = connect.createStatement()) {
            statement.executeUpdate(DROP_SQL);
            System.out.println("удаления таблиц ");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age){
        String SQL = "INSERT INTO user(name,lastName,age) VALUES(?,?,?)";
        try(Connection connect = connect();
            PreparedStatement statement = connect.prepareStatement(SQL)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setInt(3,age);
            statement.executeUpdate();
            System.out.println("маалымат кошулду");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String REMOVE_ID = "DELETE FROM user WHERE id = ?";
        try(Connection connect = connect();
            PreparedStatement statement = connect.prepareStatement(REMOVE_ID)){
            statement.setInt(1, (int) id);
            statement.executeUpdate();
            System.out.println("удаление с айдишкой");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        try(Connection connect = connect();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
          //  List<User> users = new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
               // users.add(name);

            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void cleanUsersTable() {
        String CLEAN_SQL ="TRUNCATE user";
        try(Connection connect = connect();
            Statement statement = connect.createStatement()){
            statement.executeUpdate(CLEAN_SQL);
            System.out.println("чистка таблиц");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}