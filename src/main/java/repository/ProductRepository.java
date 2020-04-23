package repository;

import java.sql.*;

public class ProductRepository {
    private static final ProductRepository productRepositoryInstance = new ProductRepository();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private ProductRepository() {}

    public static ProductRepository getInstance() { return productRepositoryInstance; }

    public Integer getPriceById(Integer id) {
        String sqlSelect = "" +
                "SELECT " +
                "PRICE " +
                "FROM PRODUCTS " +
                "WHERE PRODUCT_ID = ?";

        try(Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return result.getInt("PRICE");
            }
        } catch (SQLException e)   {
            e.printStackTrace();
        }

        return 0;
    }

    public String getSourceById(Integer id) {
        String sqlSelect = "" +
                "SELECT " +
                "SRC " +
                "FROM PRODUCTS " +
                "WHERE PRODUCT_ID = ?";

        try(Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return result.getString("SRC");
            }
        } catch (SQLException e)   {
            e.printStackTrace();
        }

        return "";
    }
}
