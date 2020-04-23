package service;

import repository.ProductRepository;

public class ProductService {
    public static final ProductService productServiceInstance = new ProductService();
    ProductRepository productRepository = ProductRepository.getInstance();

    private ProductService() {}

    public static ProductService getInstance() { return productServiceInstance; }

    public String getSourceById(Integer productId) {
        return productRepository.getSourceById(productId);
    }

    public Integer getPriceById(Integer id) {
        return productRepository.getPriceById(id);
    }
}
