package model;

import org.json.simple.JSONArray;

import java.util.Date;

public class Order {
    private Integer orderId;
    private String email;
    private String products;
    private Integer price;
    private String phoneNumber;
    private String address;
    private Integer deliveryMethod;
    private Date date;

    public Order(Integer orderId, String email, String products, Integer price, String phoneNumber, String address,
                 Integer deliveryMethod, Date date) {
        this.orderId = orderId;
        this.email = email;
        this.products = products;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.deliveryMethod = deliveryMethod;
        this.date = date;
    }

    public Order(String email, String products, Integer price, String phoneNumber, String address,
                 Integer deliveryMethod, Date date) {
        this.email = email;
        this.products = products;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.deliveryMethod = deliveryMethod;
        this.date = date;
    }

    public Order (Integer orderId, Integer price, String phoneNumber, Integer deliveryMethod, Date date){
        this.orderId = orderId;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.deliveryMethod = deliveryMethod;
        this.date = date;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
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
