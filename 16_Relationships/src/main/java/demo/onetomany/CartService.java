package demo.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart findCart(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart removeCart(Long id) {
        Cart cart = findCart(id);
        Iterator<CartItem> i = cart.getItems().iterator();
        while (i.hasNext()) {
            CartItem cartItem = i.next();
            cartItem.removeCart(cart);
            cartItemRepository.delete(cartItem);
        }
        cartRepository.save(cart);
        cartRepository.delete(cart);
        return cart;
    }

    public Cart addCartItem(Long cartId, CartItem newData) {
        Cart cart = this.findCart(cartId);
        newData.setCart(cart);
        cartItemRepository.save(newData);
        return cartRepository.save(cart);
    }
}
