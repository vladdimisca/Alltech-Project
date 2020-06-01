package repository;

import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository {
    private static final OrderRepository orderRepositoryInstance = new OrderRepository();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private OrderRepository() {}

    public static OrderRepository getInstance() { return orderRepositoryInstance; }

    public void addOrder(Order order) {
        String sqlInsert = "INSERT INTO ORDERS " +
                           "(EMAIL, PRODUCTS, PRICE, PHONE_NUMBER, ADDRESS, DELIVERY_METHOD, DATE) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?)";

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
            statement.setTimestamp(7, new java.sql.Timestamp(order.getDate().getTime()));

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

    public ArrayList<Order> getAllOrdersByEmail(String email) {
        String sqlSelect = "" +
                "SELECT " +
                "ORDER_ID, " +
                "PRICE, " +
                "PHONE_NUMBER, " +
                "DELIVERY_METHOD, " +
                "DATE " +
                "FROM ORDERS " +
                "WHERE EMAIL = ?";

        ArrayList<Order> orders = new ArrayList<>();

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlSelect);

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                Integer orderId = result.getInt("ORDER_ID");
                Integer price = result.getInt("PRICE");
                String phoneNumber = result.getString("PHONE_NUMBER");
                Integer deliveryMethod = result.getInt("DELIVERY_METHOD");
                Date date = result.getTimestamp("DATE");

                Order order = new Order(orderId, price, phoneNumber, deliveryMethod, date);
                orders.add(order);
            }
        } catch (SQLException | ClassNotFoundException e) {
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

        return orders;
    }

}
