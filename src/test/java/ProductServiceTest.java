import exceptions.OutOfStockException;
import exceptions.ProductNotFoundException;

import model.CartItem;
import model.Product;
import org.junit.jupiter.api.*;
import service.CartService;
import service.ProductService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {
    ProductService productService = ProductService.getInstance();

    Integer randomId = 1;
    Integer randomNumber = 5;
    String randomSRC = "photos/CaptureA71.JPG";
    String randomLink = "A71.jsp";
    Integer randomPrice = 430;

    Integer randomProductId = 1;
    Integer randomProductNumber = 1;
    String randomEmail = "dummy@mail.ro";

    CartItem randomCartItem = new CartItem(randomEmail, randomProductId, randomProductNumber);

    @Test
    @Order(1)
    void getSourceByIdTest() {
        boolean result = true;

        try {
            if(!randomSRC.equals(productService.getSourceById(randomId)))
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the source is correct");

    }

    @Test
    @Order(2)
    void getPriceByIdTest() {
        boolean result = true;

        try {
            if(!randomPrice.equals(productService.getPriceById(randomId)))
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the price is correct");

    }

    @Test
    @Order(3)
    void getNumberByIdTest() {
        boolean result = true;

        try {
            if(!randomNumber.equals(productService.getNumberById(randomId)))
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the number is correct");

    }

    @Test
    @Order(4)
    void getLinkByIdTest() {
        boolean result = true;

        try {
            if(!randomLink.equals(productService.getLinkById(randomId)))
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the link is correct");

    }

    @Test
    @Order(5)
    void decreaseNumberByIdTest()  {
        boolean result = true;

        try {
            productService.decreaseNumberById(randomId);
            Integer newNumber = productService.getNumberById(randomId);

            if(newNumber != randomNumber - 1)
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the number of items has been decreased");
    }

    @Test
    @Order(6)
    void restoreStockTest() {
        boolean result = true;

        try {
            productService.restoreStock(randomId, 1);
            Integer newNumber = productService.getNumberById(randomId);

            if(newNumber != randomNumber)
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the number of items has been restored");
    }

    @Test
    @Order(7)
    void restoreCartItemsByEmailTest() {
        boolean result = true;

        try {
            CartService.getInstance().addCartItem(randomCartItem);

            productService.restoreCartItemsByEmail(randomEmail);

            ArrayList<Product> products = CartService.getInstance().getCartByEmail(randomEmail);

            if(!products.isEmpty())
                result = false;

            Integer newNumber = productService.getNumberById(randomId);

            if(newNumber != randomNumber)
                result = false;

        } catch (ProductNotFoundException | OutOfStockException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the cart items have been restored");
    }

}
