package servlet;

import exceptions.EmailNotFoundException;
import exceptions.ExistingUserException;
import exceptions.WrongPasswordException;
import model.User;
import org.json.simple.JSONObject;
import service.AuthenticationService;
import service.CartService;
import service.UserService;

import javax.servlet.ServletException;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer type = Integer.parseInt(req.getParameter("type"));
        String email = req.getParameter("email");

        JSONObject json = new JSONObject();

        switch (type) {
            case 1:
                String oldPassword = req.getParameter("oldPassword");
                String newPassword = req.getParameter("newPassword");

                try {
                    UserService.getInstance().changePassword(email, oldPassword, newPassword);
                    json.put("success", "Your password was updated!");
                } catch (WrongPasswordException e) {
                    json.put("failure", e.getMessage());
                    e.printStackTrace();
                }
                break;

            case 2:
                String firstName = req.getParameter("firstName");

                UserService.getInstance().changeFirstName(email, firstName);

                json.put("success", "success");

                break;

            case 3:
                String lastName = req.getParameter("lastName");

                UserService.getInstance().changeLastName(email, lastName);

                json.put("success", "success");

                break;

            case 4:
                String newEmail = req.getParameter("newEmail");

                try {
                    UserService.getInstance().changeEmail(email, newEmail);
                    CartService.getInstance().updateEmail(email, newEmail);

                    json.put("success", "success");
                } catch (ExistingUserException e) {
                    json.put("failure", e.getMessage());
                    e.printStackTrace();
                }
                break;

        }

        resp.getWriter().write(String.valueOf(json));
    }
}
