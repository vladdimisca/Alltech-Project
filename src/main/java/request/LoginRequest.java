package request;

import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import service.AuthenticationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/sign_in")
public class LoginRequest extends HttpServlet {
    AuthenticationService authenticationService = AuthenticationService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("psw");

        try {
            authenticationService.login(email, password);
            resp.sendRedirect("user_profile.jsp");
        } catch (EmailNotFoundException | WrongPasswordException e) {
            req.setAttribute("message", e.getMessage());
            resp.sendRedirect("sign_in.jsp?message=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8));
            e.printStackTrace();
        }
    }
}
