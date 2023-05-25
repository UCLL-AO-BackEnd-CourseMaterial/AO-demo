package demo.onetomany;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartItemTest {
    private CartItem validCartItem;
    private String name = "sugar";
    private int amount = 3;
    private int price = 5;

    private Cart validCart;

    @BeforeEach
    public void init() {
        validCart = new Cart();

        validCartItem = new CartItem();
        validCartItem.setName(name);
        validCartItem.setAmount(amount);
        validCartItem.setPrice(price);
    }

    @Test
    public void givenValidCartItemAndCart_whenCartIsSetToCartItem_thenCartItemIsInCart() {
        validCartItem.setCart(validCart);
        assertNotNull(validCartItem.getCart());
        assertEquals(validCart, validCartItem.getCart());
        assertEquals(1, validCart.getItems().size());

    }
}
