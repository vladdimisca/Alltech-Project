package request;

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
public class CartRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");

        if(email != null) {
            try {
                ArrayList<Product> cart = CartService.getInstance().getCartByEmail(email);
                JSONArray jsonArray = new JSONArray();

                for (Product item : cart) {
                    JSONObject json = new JSONObject();

                    json.put("source", item.getSource());
                    json.put("number", item.getNumber());

                    jsonArray.add(json);
                }

                resp.getWriter().write(String.valueOf(jsonArray));
            } catch (ProductNotFoundException e) {
                JSONObject json = new JSONObject();

                json.put("failure", "Some of your products may not be added due to some technical issues.");

                resp.getWriter().write(String.valueOf(json));
                e.printStackTrace();
            }
        } else {
            Integer productId = Integer.parseInt(req.getParameter("productId"));

            JSONObject json = new JSONObject();

            try {
                int productNumber = ProductService.getInstance().getNumberById(productId);

                if(productNumber == 0) {
                    json.put("stock", "Out of stock");
                }
            } catch (ProductNotFoundException e) {
                json.put("stock", "Temporary unavailable");
                e.printStackTrace();
            }

            resp.getWriter().write(String.valueOf(json));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Integer productId = Integer.parseInt(req.getParameter("productId"));

        CartItem item = new CartItem(email, productId, 1);
        JSONObject json = new JSONObject();

        try {
             CartService.getInstance().addCartItem(item);

             json.put("success", "Added to cart");
        } catch(OutOfStockException e) {
            json.put("failure", "Out of stock");
            e.printStackTrace();
        } catch (ProductNotFoundException e) {
            json.put("failure", "Product couldn't be added due to some technical issues");
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
