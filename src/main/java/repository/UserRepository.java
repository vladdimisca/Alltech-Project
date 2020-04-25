package repository;

import model.User;

import java.sql.*;

public class UserRepository {
    private static final UserRepository userRepositoryInstance = new UserRepository();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private UserRepository() { }

    public static UserRepository getInstance() {
        return userRepositoryInstance;
    }

    public void addUser(User user) {
        String sqlInsert = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlInsert);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        String sqlSelect = "" +
                "SELECT " +
                "FIRST_NAME, " +
                "LAST_NAME, " +
                "EMAIL, " +
                "PASSWORD " +
                "FROM USERS " +
                "WHERE EMAIL = ?";

        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect);

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                String firstName = result.getString("FIRST_NAME");
                String lastName = result.getString("LAST_NAME");
                String userEmail = result.getString("EMAIL");
                String password = result.getString("PASSWORD");

                user = new User(firstName, lastName, userEmail, password);
            }

            dbConnection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }

        return user;
    }

    public void removeUserByEmail(String email) {
        String sqlDelete = "" +
                "DELETE " +
                "FROM " +
                "USERS " +
                "WHERE EMAIL = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlDelete);

            statement.setString(1, email);
            statement.execute();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }
    }
}
