package service;

import model.Order;
import repository.OrderRepository;

import java.util.ArrayList;

public class OrderService {
    private static final OrderService orderServiceInstance = new OrderService();
    OrderRepository orderRepository = OrderRepository.getInstance();

    private OrderService() {}

    public static OrderService getInstance() {
        return orderServiceInstance;
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);

        CartService.getInstance().removeCartItemsByEmail(order.getEmail());
    }

    public ArrayList<Order> getAllOrdersByEmail(String email) {
        return orderRepository.getAllOrdersByEmail(email);
    }
}
