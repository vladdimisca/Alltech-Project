package servlet;

import model.Order;
import model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.CartService;
import service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Integer price = Integer.parseInt(req.getParameter("price"));
        String phoneNumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        Integer deliveryMethod = Integer.parseInt(req.getParameter("deliveryMethod"));

        ArrayList<Product> products = CartService.getInstance().getCartByEmail(email);
        JSONArray jsonArray = new JSONArray();

        for(Product product : products) {
            JSONObject json = new JSONObject();

            json.put("productId", product.getProductId());
            json.put("number", product.getNumber());
            json.put("price", product.getPrice());
            json.put("link", product.getLink());
            json.put("source", product.getSource());

            jsonArray.add(json);
        }

        Order order = new Order(email, jsonArray, price, phoneNumber, address, deliveryMethod);

        OrderService.getInstance().addOrder(order);
    }
}
