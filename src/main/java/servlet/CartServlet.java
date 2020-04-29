package servlet;

import exceptions.OutOfStockException;
import exceptions.ProductNotFoundException;
import model.CartItem;
import model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.CartService;
import service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
@WebServlet("/shopping_cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");

        ArrayList<Product> cart = CartService.getInstance().getCartByEmail(email);
        JSONArray jsonArray = new JSONArray();

        for (Product item : cart) {
            JSONObject json = new JSONObject();

            json.put("productId", item.getProductId());
            json.put("source", item.getSource());
            json.put("number", item.getNumber());

            jsonArray.add(json);
        }

        resp.getWriter().write(String.valueOf(jsonArray));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Integer productId = Integer.parseInt(req.getParameter("productId"));

        CartItem item = new CartItem(email, productId, 1);
        JSONObject json = new JSONObject();

        try {
             CartService.getInstance().addCartItem(item);
             int productNumber = CartService.getInstance().getProductNumberByEmail(email, productId);

             json.put("success", "Added to cart");
             json.put("number", productNumber);
        } catch(OutOfStockException e) {
            json.put("failure", "Out of stock");
            e.printStackTrace();
        } catch (ProductNotFoundException e) {
            json.put("failure", "Product couldn't be added due to some technical issues");
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int type = Integer.parseInt(req.getParameter("type"));
        String email = req.getParameter("email");
        Integer productId = Integer.parseInt(req.getParameter("productId"));

        JSONObject json = new JSONObject();

        if(type == 1) {
            try {
                int productNumber = CartService.getInstance().getProductNumberByEmail(email, productId);
                CartService.getInstance().removeCartItem(email, productId);

                json.put("success", "Item deleted from cart");

                ProductService.getInstance().restoreStock(productId, productNumber);
            } catch (ProductNotFoundException e) {
                json.put("failure", "Product couldn't be restored due to some technical issues");
                e.printStackTrace();
            }
        } else {
            CartService.getInstance().decreaseNumberByEmail(email, productId);
            int productNumber = CartService.getInstance().getProductNumberByEmail(email, productId);

            json.put("success", "Updated");
            json.put("number", productNumber);
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
