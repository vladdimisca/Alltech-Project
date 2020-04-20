package request;

import exceptions.ExistingUserException;
import model.User;
import service.AuthenticationService;

<<<<<<< Updated upstream
=======
import javax.servlet.ServletException;
>>>>>>> Stashed changes
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

<<<<<<< Updated upstream
@WebServlet("/guest_profile")
public class RegisterRequest extends HttpServlet {
    AuthenticationService authenticationService = AuthenticationService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
=======
@WebServlet("/registerServlet")
public class RegisterRequest extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>>>>>>> Stashed changes
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");
        String password = req.getParameter("psw");

        User user = new User(firstName, lastName, email, password);

<<<<<<< Updated upstream
        final String message = "You have been registered successfully!";

        try {
            authenticationService.register(user);
            resp.sendRedirect("sign_in.jsp?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8));
=======
        System.out.println(user);

        String message = "A reusit!";
        try {
            AuthenticationService.getInstance().register(user);
            System.out.println(user);
            resp.getWriter().write(message);
>>>>>>> Stashed changes
        } catch (ExistingUserException e) {
            resp.sendRedirect("guest_profile.jsp?message=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8));
            e.printStackTrace();
        }
    }
}
