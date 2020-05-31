package repository;

import exceptions.ProductNotFoundException;
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

    public Integer getProductNumberByEmail(String email, Integer productId) {
        String sqlSelect = "" +
                "SELECT " +
                "NUMBER " +
                "FROM CART " +
                "WHERE EMAIL = ? AND PRODUCT_ID = ?";

        int number = 0;

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlSelect);

            statement.setString(1, email);
            statement.setInt(2, productId);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                number = result.getInt("NUMBER");
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

        return number;
    }

    public void addCartItem(CartItem item) {
        Integer productNumber = getProductNumberByEmail(item.getEmail(), item.getProductId());

        Connection dbConnection = null;
        PreparedStatement statement = null;

        if(productNumber == 0) {
            String sqlInsert = "INSERT INTO Cart (EMAIL, PRODUCT_ID, NUMBER) VALUES (?, ?, ?)";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection(url, username, password);
                statement = dbConnection.prepareStatement(sqlInsert);

                statement.setString(1, item.getEmail());
                statement.setInt(2, item.getProductId());
                statement.setInt(3, item.getNumber());

                statement.executeUpdate();
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
        } else {
            productNumber++;

            String sqlUpdate = "" +
                    "UPDATE CART " +
                    "SET NUMBER = ? " +
                    "WHERE PRODUCT_ID = ?";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection(url, username, password);
                statement = dbConnection.prepareStatement(sqlUpdate);

                statement.setInt(1, productNumber);
                statement.setInt(2, item.getProductId());

                statement.executeUpdate();
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
        }
    }

    public void removeCartItem(String email, Integer productId) {
        String sqlDelete = "" +
                "DELETE " +
                "FROM " +
                "CART " +
                "WHERE EMAIL = ? AND PRODUCT_ID = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlDelete);

            statement.setString(1, email);
            statement.setInt(2, productId);
            statement.execute();
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
    }

    public ArrayList<Product> getCartByEmail(String email) {
        String sqlSelect = "" +
                "SELECT " +
                "PRODUCT_ID, " +
                "NUMBER " +
                "FROM CART " +
                "WHERE EMAIL = ?";

        ArrayList<Product> cart = new ArrayList<>();

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlSelect);

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                Integer productId = result.getInt("PRODUCT_ID");
                Integer number = result.getInt("NUMBER");

                String src = productService.getSourceById(productId);
                Integer price = productService.getPriceById(productId);
                String link = productService.getLinkById(productId);

                Product item = new Product(productId, number, src, link, price);
                cart.add(item);
            }
        } catch (SQLException | ClassNotFoundException | ProductNotFoundException e) {
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

        return cart;
    }

    public void updateEmail(String oldEmail, String newEmail) {
        String sqlUpdate = "" +
                "UPDATE CART " +
                "SET EMAIL = ? " +
                "WHERE EMAIL = ?";

        Connection dbConnection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            statement = dbConnection.prepareStatement(sqlUpdate);

            statement.setString(1, newEmail);
            statement.setString(2, oldEmail);

            statement.executeUpdate();
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
    }

    public void decreaseNumberByEmail(String email, Integer productId) {
        int productNumber = getProductNumberByEmail(email, productId);

        if(productNumber > 1) {
            productNumber--;

            String sqlUpdate = "" +
                    "UPDATE CART " +
                    "SET NUMBER = ? " +
                    "WHERE EMAIL = ? AND PRODUCT_ID = ?";

            Connection dbConnection = null;
            PreparedStatement statement = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection(url, username, password);
                statement = dbConnection.prepareStatement(sqlUpdate);

                statement.setInt(1, productNumber);
                statement.setString(2, email);
                statement.setInt(3, productId);

                statement.executeUpdate();

                ProductService.getInstance().restoreStock(productId, 1);
            } catch (SQLException | ClassNotFoundException | ProductNotFoundException e) {
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

    public void removeCartItemsByEmail(String email) {
        String sqlDelete = "" +
                "DELETE " +
                "FROM " +
                "CART " +
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
}

