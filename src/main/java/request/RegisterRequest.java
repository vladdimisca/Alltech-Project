package request;

import exceptions.ExistingUserException;
import model.User;
import service.AuthenticationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/guest_profile")
public class RegisterRequest extends HttpServlet {
    AuthenticationService authenticationService = AuthenticationService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");
        String password = req.getParameter("psw");

        User user = new User(firstName, lastName, email, password);

        final String message = "You have been registered successfully!";

        try {
            authenticationService.register(user);
            resp.sendRedirect("sign_in.jsp?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8));
        } catch (ExistingUserException e) {
            resp.sendRedirect("guest_profile.jsp?message=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8));
            e.printStackTrace();
        }
    }
}
