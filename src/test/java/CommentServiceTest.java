import model.Comment;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import service.CommentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentServiceTest {
    CommentService commentService = CommentService.getInstance();
    String randomEmail = "dummy@mail.ro";
    Integer randomProductId = 1;
    Date randomDate;

    {
        try {
            randomDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("02/06/2020 18:20:10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    String randomMessage = "I like this product";

    @Test
    @Order(1)
    void addCommentToProductByEmail() {
        boolean result = false;

        commentService.addCommentToProductByEmail(randomEmail, randomProductId, randomDate, randomMessage);

        ArrayList<Comment> comments = commentService.getCommentsById(randomProductId);

        for(Comment comment: comments){
            if(comment.getMessage().equals(randomMessage)){
                result = true;
                break;
            }
        }

        assertTrue(result, "Check if the comment has been added");
    }

    @Test
    @Order(2)
    void getCommentsByIdTest() {
        boolean result = false;

        ArrayList<Comment> comments = commentService.getCommentsById(randomProductId);

        for(Comment comment: comments){
            if(comment.getMessage().equals(randomMessage)){
                result = true;
                break;
            }
        }

        assertTrue(result, "Check if the comment has been added");
    }

    @Test
    @Order(3)
    void removeEmailFromCommentsTest() {
        boolean result = false;

        commentService.removeEmailFromComments(randomEmail);

        ArrayList<Comment> comments = commentService.getCommentsById(randomProductId);

        for (Comment comment : comments) {
            if (comment.getMessage().equals(randomMessage))
                if (comment.getEmail().equals("[deleted]"))
                    result = true;
        }

        assertTrue(result, "Check if the email has been deleted");
    }

    @Test
    @Order(3)
    void removeCommentByIdTest() {
        boolean result = true;

        ArrayList<Comment> comments = commentService.getCommentsById(randomProductId);

        for (Comment comment : comments) {
            if (comment.getMessage().equals(randomMessage)) {
                commentService.removeCommentById(comment.getCommentId());
            }
        }

        ArrayList<Comment> comments2 = commentService.getCommentsById(randomProductId);

        for (Comment comment : comments2) {
            if (comment.getMessage().equals(randomMessage)) {
                result = false;
                break;
            }
        }

        assertTrue(result, "Check if the comment has been deleted");

    }
}