package repository;

import model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepository {
    private static final OrderRepository orderRepositoryInstance = new OrderRepository();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private OrderRepository() {}

    public static OrderRepository getInstance() { return orderRepositoryInstance; }

    public void addOrder(Order order) {
        String sqlInsert = "INSERT INTO ORDERS " +
                           "(EMAIL, PRODUCTS, PRICE, PHONE_NUMBER, ADDRESS, DELIVERY_METHOD) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlInsert);

            statement.setString(1, order.getEmail());
            statement.setString(2, String.valueOf(order.getProducts()));
            statement.setInt(3, order.getPrice());
            statement.setString(4, order.getPhoneNumber());
            statement.setString(5, order.getAddress());
            statement.setInt(6, order.getDeliveryMethod());

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
