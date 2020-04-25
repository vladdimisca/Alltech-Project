package model;

public class CartItem {
    private Integer productId;
    private Integer number;
    private String email;

    public CartItem(String email, Integer productId, Integer number) {
        this.email = email;
        this.productId = productId;
        this.number = number;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId=" + productId +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}
