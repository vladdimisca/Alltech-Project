package service;

import exceptions.ProductNotFoundException;
import repository.ProductRepository;

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
}
