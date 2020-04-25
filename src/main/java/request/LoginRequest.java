package request;

import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import org.json.simple.JSONObject;
import service.AuthenticationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unchecked")
@WebServlet("/sign_in")
public class LoginRequest extends HttpServlet {
    AuthenticationService authenticationService = AuthenticationService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        JSONObject json = new JSONObject();

        try {
            authenticationService.login(email, password);
            json.put("success", "success");
        } catch (EmailNotFoundException | WrongPasswordException e) {
            json.put("failure", e.getMessage());
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }
}
