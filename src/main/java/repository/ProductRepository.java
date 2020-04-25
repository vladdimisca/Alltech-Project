package repository;

import exceptions.ProductNotFoundException;

import java.sql.*;

public class ProductRepository {
    private static final ProductRepository productRepositoryInstance = new ProductRepository();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private ProductRepository() {}

    public static ProductRepository getInstance() { return productRepositoryInstance; }

    public Integer getPriceById(Integer id) throws ProductNotFoundException {
        String sqlSelect = "" +
                "SELECT " +
                "PRICE " +
                "FROM PRODUCTS " +
                "WHERE PRODUCT_ID = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return result.getInt("PRICE");
            }
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }

        throw new ProductNotFoundException("The product couldn't be found!");
    }

    public String getSourceById(Integer id) throws ProductNotFoundException {
        String sqlSelect = "" +
                "SELECT " +
                "SRC " +
                "FROM PRODUCTS " +
                "WHERE PRODUCT_ID = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return result.getString("SRC");
            }
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }

        throw new ProductNotFoundException("The product couldn't be found!");
    }

    public Integer getNumberById(Integer id) throws ProductNotFoundException {
        String sqlSelect = "" +
                "SELECT " +
                "NUMBER " +
                "FROM PRODUCTS " +
                "WHERE PRODUCT_ID = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return result.getInt("NUMBER");
            }
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }

        throw new ProductNotFoundException("The product couldn't be found!");
    }

    public void decreaseNumberById(Integer id) throws ProductNotFoundException {
        int productNumber = getNumberById(id) - 1;

        String sqlUpdate = "" +
                "UPDATE " +
                "PRODUCTS " +
                "SET NUMBER = ? " +
                "WHERE PRODUCT_ID = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlUpdate);

            statement.setInt(1, productNumber);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)   {
            e.printStackTrace();
        }
    }
}
