package model;

public class Product {
    private Integer productId;
    private Integer number;
    private String source;
    private String link;
    private Integer price;

    public Product(Integer productId, Integer number, String source, String link, Integer price) {
        this.productId = productId;
        this.number = number;
        this.source = source;
        this.link = link;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", number=" + number +
                ", source='" + source + '\'' +
                ", price=" + price +
                '}';
    }
}
