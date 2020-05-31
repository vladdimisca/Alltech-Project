package service;

import exceptions.OutOfStockException;
import exceptions.ProductNotFoundException;
import model.CartItem;
import model.Product;
import repository.CartRepository;

import java.util.ArrayList;

public class CartService {
    private static final CartService cartServiceInstance = new CartService();
    CartRepository cartRepository = CartRepository.getInstance();
    ProductService productService = ProductService.getInstance();

    private CartService() {}

    public static CartService getInstance() {
        return cartServiceInstance;
    }

    public void addCartItem(CartItem item) throws ProductNotFoundException, OutOfStockException {
        int productNumber = productService.getNumberById(item.getProductId());

        if(productNumber == 0)
            throw new OutOfStockException("This product is out of stock!");

        cartRepository.addCartItem(item);
        productService.decreaseNumberById(item.getProductId());
    }

    public ArrayList<Product> getCartByEmail(String email) {
        return cartRepository.getCartByEmail(email);
    }

    public void removeCartItem(String email, Integer productId) {
        cartRepository.removeCartItem(email, productId);
    }

    public Integer getProductNumberByEmail(String email, Integer productId) {
        return cartRepository.getProductNumberByEmail(email, productId);
    }

    public void updateEmail(String oldEmail, String newEmail) {
        cartRepository.updateEmail(oldEmail, newEmail);
    }

    public void decreaseNumberByEmail(String email, Integer productId) {
        cartRepository.decreaseNumberByEmail(email, productId);
    }

    public Integer getTotalPriceByEmail(String email) {
        ArrayList<Product> cart = getCartByEmail(email);

        int sum = 0;

        for(Product item : cart) {
            sum += item.getPrice() * item.getNumber();
        }

        return sum;
    }

    public void removeCartItemsByEmail(String email) {
        cartRepository.removeCartItemsByEmail(email);
    }
}
