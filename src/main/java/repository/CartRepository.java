package repository;

import model.CartItem;
import model.Product;
import service.ProductService;

import java.sql.*;
import java.util.ArrayList;

public class CartRepository {
    private static final CartRepository cartRepositoryInstance = new CartRepository();
    ProductService productService = ProductService.getInstance();
    String url = "jdbc:mysql://localhost/alltech";
    String username = "root";
    String password = "";

    private CartRepository() { }

    public static CartRepository getInstance() {
        return cartRepositoryInstance;
    }

    public void addCartItem(CartItem item) {
        String sqlInsert = "INSERT INTO Cart (EMAIL, PRODUCT_ID, NUMBER) VALUES (?, ?, ?)";

        try(Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlInsert)) {

            statement.setString(1, item.getEmail());
            statement.setString(2, item.getProductId().toString());
            statement.setString(3, item.getNumber().toString());

            statement.executeUpdate();
        } catch (SQLException e)   {
            e.printStackTrace();
        }
    }

    public Integer getProductNumberByEmail(String email, Integer productId) {
        String sqlSelect = "" +
                "SELECT " +
                "NUMBER " +
                "FROM CART " +
                "WHERE EMAIL = ? AND PRODUCT_ID = ?";

        int number = 0;

        try(Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect)) {

            statement.setString(1, email);
            statement.setInt(2, productId);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                number = result.getInt("NUMBER");
            }
        } catch (SQLException e)   {
            e.printStackTrace();
        }

        return number;
    }

    public void removeCartItem(String email, Integer productId) {
        String sqlDelete = "" +
                "DELETE " +
                "FROM " +
                "CART " +
                "WHERE EMAIL = ? AND PRODUCT_ID = ?";

        try(Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlDelete)) {

            statement.setString(1, email);
            statement.setInt(2, productId);
            statement.execute();
        } catch (SQLException e)   {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getCartByEmail(String email) {
        String sqlSelect = "" +
                "SELECT " +
                "PRODUCT_ID, " +
                "NUMBER " +
                "FROM CART " +
                "WHERE EMAIL = ?";

        ArrayList<Product> cart = new ArrayList<>();

        try(Connection dbConnection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = dbConnection.prepareStatement(sqlSelect)) {

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                Integer productId = result.getInt("PRODUCT_ID");
                Integer number = result.getInt("NUMBER");

                String src = productService.getSourceById(productId);
                Integer price = productService.getPriceById(productId);
                Product item = new Product(productId, number, src, price);
                cart.add(item);
            }
        } catch (SQLException e)   {
            e.printStackTrace();
        }

        return cart;
    }
}

