package model;

import org.json.simple.JSONArray;

public class Order {
    private Integer orderId;
    private String email;
    private JSONArray products;
    private Integer price;
    private String phoneNumber;
    private String address;
    private Integer deliveryMethod;

    public Order(Integer orderId, String email, JSONArray products, Integer price, String phoneNumber, String address,
                 Integer deliveryMethod) {
        this.orderId = orderId;
        this.email = email;
        this.products = products;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.deliveryMethod = deliveryMethod;
    }

    public Order(String email, JSONArray products, Integer price, String phoneNumber, String address,
                 Integer deliveryMethod) {
        this.email = email;
        this.products = products;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.deliveryMethod = deliveryMethod;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JSONArray getProducts() {
        return products;
    }

    public void setProducts(JSONArray products) {
        this.products = products;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Integer deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
