package repository;

import model.User;
import service.EncryptionService;

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

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlInsert);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

        Connection dbConnection = null;
        PreparedStatement statement = null;

        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlSelect);

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                String firstName = result.getString("FIRST_NAME");
                String lastName = result.getString("LAST_NAME");
                String userEmail = result.getString("EMAIL");
                String password = result.getString("PASSWORD");

                user = new User(firstName, lastName, userEmail, password);
            }
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public void removeUserByEmail(String email) {
        String sqlDelete = "" +
                "DELETE " +
                "FROM " +
                "USERS " +
                "WHERE EMAIL = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlDelete);

            statement.setString(1, email);
            statement.execute();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void changePassword (String email, String newPassword) {
        String sqlUpdate = "" +
                "UPDATE " +
                "USERS " +
                "SET PASSWORD = ? " +
                "WHERE EMAIL = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlUpdate);

            String newPasswordEncrypted = EncryptionService.getInstance().encrypt(newPassword);

            statement.setString(1, newPasswordEncrypted);
            statement.setString(2, email);

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeFirstName (String email, String newName) {
        String sqlUpdate = "" +
                "UPDATE " +
                "USERS " +
                "SET FIRST_NAME = ? " +
                "WHERE EMAIL = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlUpdate);

            statement.setString(1, newName);
            statement.setString(2, email);

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeLastName (String email, String newName) {
        String sqlUpdate = "" +
                "UPDATE " +
                "USERS " +
                "SET LAST_NAME = ? " +
                "WHERE EMAIL = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlUpdate);

            statement.setString(1, newName);
            statement.setString(2, email);

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeEmail (String email, String newEmail) {
        String sqlUpdate = "" +
                "UPDATE " +
                "USERS " +
                "SET EMAIL = ? " +
                "WHERE EMAIL = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlUpdate);

            statement.setString(1, newEmail);
            statement.setString(2, email);

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        } finally {
            try {
                assert dbConnection != null;
                dbConnection.close();

                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
