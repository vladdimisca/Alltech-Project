package request;

import exceptions.ProductNotFoundException;
import org.json.simple.JSONObject;
import service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
@SuppressWarnings("unchecked")
public class ProductRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
