package request;

import exceptions.ExistingUserException;
import model.User;
import org.json.simple.JSONObject;
import service.AuthenticationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unchecked")
@WebServlet("/register")
public class RegisterRequest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(firstName, lastName, email, password);
        final String message = "You have been successfully registered!";
        JSONObject json = new JSONObject();

        try {
            AuthenticationService.getInstance().register(user);
            json.put("message", message);
        } catch (ExistingUserException e) {
            json.put("message", e.getMessage());
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
