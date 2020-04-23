package request;

import model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.CartService;

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

        ArrayList<Product> cart = CartService.getInstance().getCartByEmail(email);
        JSONArray jsonArray = new JSONArray();

        for(Product item : cart) {
            JSONObject json = new JSONObject();

            json.put("source", item.getSource());
            json.put("number", item.getNumber());

            jsonArray.add(json);
        }

        resp.getWriter().write(String.valueOf(jsonArray));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");

    }
}
