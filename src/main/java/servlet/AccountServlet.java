package servlet;

import exceptions.ExistingUserException;
import exceptions.WrongPasswordException;
import model.User;
import org.json.simple.JSONObject;
import service.CartService;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            UserService.getInstance().removeUserByEmail(email, password);

            json.put("success", "success");
        } catch (WrongPasswordException e) {
            json.put("failure", e.getMessage());
        }

        resp.getWriter().write(String.valueOf(json));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int type = Integer.parseInt(req.getParameter("type"));
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
                }
                break;
            default:
                System.out.println("There is a problem with the given type of update!");
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
