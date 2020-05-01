package model;

import java.util.Date;

public class Comment {
    String email;
    Integer productId;
    Date date;
    String message;

    public Comment(String email, Integer productId, Date date, String message) {
        this.email = email;
        this.productId = productId;
        this.date = date;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
