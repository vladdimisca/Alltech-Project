package service;

import exceptions.ProductNotFoundException;
import model.Product;
import repository.ProductRepository;

import java.util.ArrayList;

public class ProductService {
    public static final ProductService productServiceInstance = new ProductService();
    ProductRepository productRepository = ProductRepository.getInstance();

    private ProductService() {}

    public static ProductService getInstance() { return productServiceInstance; }

    public String getSourceById(Integer productId) throws ProductNotFoundException {
        return productRepository.getSourceById(productId);
    }

    public Integer getPriceById(Integer id) throws ProductNotFoundException {
        return productRepository.getPriceById(id);
    }

    public Integer getNumberById(Integer id) throws ProductNotFoundException {
        return productRepository.getNumberById(id);
    }

    public void decreaseNumberById(Integer id) throws ProductNotFoundException {
        productRepository.decreaseNumberById(id);
    }

    public void restoreStock(Integer id, Integer productNumber) throws ProductNotFoundException {
        productRepository.restoreStock(id, productNumber);
    }

    public void restoreCartItemsByEmail(String email) throws ProductNotFoundException {
        ArrayList<Product> cart = CartService.getInstance().getCartByEmail(email);

        for(Product item : cart) {
            productRepository.restoreStock(item.getProductId(), item.getNumber());
            CartService.getInstance().removeCartItem(email, item.getProductId());
        }
    }
}
