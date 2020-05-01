package servlet;

import model.Comment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.CommentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unchecked")
@WebServlet("/comments")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        String message = req.getParameter("message");

        JSONObject json = new JSONObject();

        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(req.getParameter("date"));

            CommentService.getInstance().addCommentToProductByEmail(email, productId, date, message);

            json.put("success", "Your comment has been successfully added!");
        } catch (ParseException e) {
            json.put("failure", "Date error!");
            e.printStackTrace();
        }

        resp.getWriter().write(String.valueOf(json));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer productId = Integer.parseInt(req.getParameter("productId"));

        ArrayList<Comment> comments = CommentService.getInstance().getCommentsById(productId);
        JSONArray jsonArray = new JSONArray();

        for(Comment comment : comments) {
            JSONObject json = new JSONObject();

            String formattedDate = comment.getDate().toString();

            json.put("email", comment.getEmail());
            json.put("date", formattedDate.substring(0, formattedDate.indexOf('.')));
            json.put("message", comment.getMessage());

            jsonArray.add(json);
        }

        resp.getWriter().write(String.valueOf(jsonArray));
    }
}
