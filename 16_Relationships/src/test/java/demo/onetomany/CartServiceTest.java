package demo.onetomany;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    CartItemRepository cartItemRepository;

    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartService cartService;

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
    public void givenCartWithoutItem_whenValidItemIsAdded_thenCartHasCartItem(){
        //given
        when(cartRepository.findById(0L)).thenReturn(Optional.of(validCart));
        when(cartRepository.save(validCart)).thenReturn(validCart);
        when(cartItemRepository.save(validCartItem)).thenReturn(validCartItem);
        //when 
        cartService.addCartItem(0L, validCartItem);
        // then
        assertEquals(1, validCart.getItems().size());
        assertTrue(validCart.getItems().contains(validCartItem));
        assertEquals(validCart, validCartItem.getCart());
        verify(cartRepository).save(validCart);
        verify(cartItemRepository).save(validCartItem);
    }
}
