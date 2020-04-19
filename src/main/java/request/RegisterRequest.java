package request;

import exceptions.ExistingUserException;
import model.User;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterRequest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(firstName, lastName, email, password);

        String message = null;
        try {
            AuthenticationService.getInstance().register(user);
            resp.getWriter().write(message);
        } catch (ExistingUserException e) {
            resp.getWriter().write(e.getMessage());
            e.printStackTrace();
        }

    }
}
