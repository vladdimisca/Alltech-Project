package service;

import model.Comment;
import repository.CommentRepository;

import java.util.ArrayList;
import java.util.Date;

public class CommentService {
    private static final CommentService commentServiceInstance = new CommentService();
    CommentRepository commentRepository = CommentRepository.getInstance();

    private CommentService() {}

    public static CommentService getInstance() {
        return commentServiceInstance;
    }

    public void addCommentToProductByEmail(String email, Integer productId, Date date, String message) {
        commentRepository.addCommentToProductByEmail(email, productId, date, message);
    }

    public ArrayList<Comment> getCommentsById(Integer productId) {
        return commentRepository.getCommentsById(productId);
    }

    public void removeEmailFromComments(String email) {
        commentRepository.removeEmailFromComments(email);
    }

    public void removeCommentById(Integer commentId) {
        commentRepository.removeCommentById(commentId);
    }
}
