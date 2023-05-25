package demo.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable("id") Long id) {
        return cartService.findCart(id);
    }

    @DeleteMapping("/{id}")
    public Cart removeCart(@PathVariable("id") Long id) {
        return cartService.removeCart(id);
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @PostMapping("/{cartId}/cartItem")
    public Cart addCartItemToCart(@PathVariable("cartId") Long cartId,
            @RequestBody CartItem cartItem) {
        return cartService.addCartItem(cartId, cartItem);
    }
}
