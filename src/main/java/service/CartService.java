package service;

import model.CartItem;
import model.Product;
import repository.CartRepository;

import java.util.ArrayList;

public class CartService {
    private static final CartService cartServiceInstance = new CartService();
    CartRepository cartRepository = CartRepository.getInstance();

    private CartService() {}

    public static CartService getInstance() {
        return cartServiceInstance;
    }

    public void addCartItem(CartItem item) {
        cartRepository.addCartItem(item);
    }

    public ArrayList<Product> getCartByEmail(String email) {
        return cartRepository.getCartByEmail(email);
    }
}
