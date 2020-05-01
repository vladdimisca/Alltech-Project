package repository;

import model.Comment;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

public class CommentRepository {
    private static final CommentRepository commentRepositoryInstance = new CommentRepository();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private CommentRepository() {}

    public static CommentRepository getInstance() { return commentRepositoryInstance; }

    public void addCommentToProductByEmail(String email, Integer productId, Date date, String message) {
        String sqlInsert = "INSERT INTO COMMENTS (EMAIL, PRODUCT_ID, DATE, MESSAGE) VALUES (?, ?, ?, ?)";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlInsert);

            statement.setString(1, email);
            statement.setInt(2, productId);
            statement.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
            statement.setString(4, message);

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

    public ArrayList<Comment> getCommentsById(Integer productId) {
        String sqlSelect = "" +
                "SELECT " +
                "EMAIL, " +
                "DATE, " +
                "MESSAGE " +
                "FROM COMMENTS " +
                "WHERE PRODUCT_ID = ?";

        ArrayList<Comment> comments = new ArrayList<>();

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlSelect);

            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                String email = result.getString("EMAIL");
                Date date = result.getTimestamp("DATE");
                String message = result.getString("MESSAGE");


                Comment comment = new Comment(email, productId, date, message);
                comments.add(comment);
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

        return comments;
    }
}
