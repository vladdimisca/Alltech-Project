package request;

import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import org.json.simple.JSONObject;
import service.AuthenticationService;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletion_page")
public class RemoveUserRequest extends HttpServlet {
    UserService userService = UserService.getInstance();

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        JSONObject json = new JSONObject();

        try {
            AuthenticationService.getInstance().login(email, password);
            userService.removeUserByEmail(email);

            json.put("success", "success");
        } catch (EmailNotFoundException | WrongPasswordException e) {
            json.put("failure", e.getMessage());
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
