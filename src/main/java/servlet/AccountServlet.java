package servlet;

import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import model.User;
import org.json.simple.JSONObject;
import service.AuthenticationService;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unchecked")
@WebServlet("/user_account")
public class AccountServlet extends HttpServlet {
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        JSONObject json = new JSONObject();

        try {
            AuthenticationService.getInstance().login(email, password);
            UserService.getInstance().removeUserByEmail(email);

            json.put("success", "success");
        } catch (EmailNotFoundException | WrongPasswordException e) {
            json.put("failure", e.getMessage());
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
