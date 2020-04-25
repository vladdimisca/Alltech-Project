package request;

import model.User;
import org.json.simple.JSONObject;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unchecked")
@WebServlet("/user_profile")
public class ProfileRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        User user = UserService.getInstance().getUserByEmail(email);

        JSONObject json = new JSONObject();

        json.put("firstName", user.getFirstName());
        json.put("lastName", user.getLastName());
        json.put("email", user.getEmail());

        resp.getWriter().write(String.valueOf(json));
    }
}
