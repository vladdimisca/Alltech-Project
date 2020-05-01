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
class CartServiceTest {
    CartService cartService = CartService.getInstance();

    Integer randomProductId = 1;
    Integer randomNumber = 2;
    String newEmail = "new.dummy@mail.ro";
    String randomEmail = "dummy@mail.ro";

    CartItem randomCartItem = new CartItem(randomEmail, randomProductId, randomNumber);

    @Test
    @Order(1)
    void addCartItemTest() {
        boolean result = true;

        try {
            cartService.addCartItem(randomCartItem);
        } catch (ProductNotFoundException | OutOfStockException e) {
            e.printStackTrace();
        }

        ArrayList <Product> products = cartService.getCartByEmail(randomEmail);

        if(products.isEmpty())
            result = false;

        assertTrue(result, "Check if the product was added to cart");
    }

    @Test
    @Order(2)
    void getCartByEmailTest() {
        boolean result = true;

        ArrayList <Product> products = cartService.getCartByEmail(randomEmail);

        Product product = products.get(0);

        Integer id = product.getProductId();

        if(!id.equals(randomProductId))
            result = false;

        assertTrue(result, "Check if the cart item was added correctly - the product id is incorrect");

    }

    @Test
    @Order(3)
    void getProductNumberByEmailTest() {
        boolean result = true;

        Integer number = cartService.getProductNumberByEmail(randomEmail, randomProductId);

        if(!number.equals(randomNumber))
            result = false;

        assertTrue(result, "Check if the cart item was added correctly - the product number is incorrect");

    }

    @Test
    @Order(4)
    void decreaseNumberByEmailTest() {
        boolean result = true;

        cartService.decreaseNumberByEmail(randomEmail, randomProductId);

        Integer number = cartService.getProductNumberByEmail(randomEmail, randomProductId);

        if(!number.equals(randomNumber-1))
             result = false;

        assertTrue(result, "Check if the product number was decreased");

    }

    @Test
    @Order(5)
    void getTotalPriceByEmailTest() {
        boolean result = true;

        Integer price = cartService.getTotalPriceByEmail(randomEmail);

        try {
            if(!price.equals(ProductService.getInstance().getPriceById(randomProductId)))
                result = false;
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result, "Check if the total price is calculated correctly");
    }

    @Test
    @Order(6)
    void updateEmailTest() {
        boolean result = true;

        cartService.updateEmail(randomEmail, newEmail);

        ArrayList <Product> products = cartService.getCartByEmail(newEmail);

        Product product = products.get(0);

        Integer id = product.getProductId();

        if(!id.equals(randomProductId))
            result = false;

        assertTrue(result, "Check if the email was updated");
    }

    @Test
    @Order(7)
    void removeCartItemTest() {
        boolean result = true;

        cartService.removeCartItem(newEmail, randomProductId);

        ArrayList <Product> products = cartService.getCartByEmail(newEmail);

        if(!products.isEmpty())
            result = false;

        assertTrue(result, "Check if product has been removed");
    }
}
