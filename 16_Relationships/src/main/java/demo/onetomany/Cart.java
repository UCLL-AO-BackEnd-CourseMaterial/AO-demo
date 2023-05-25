package demo.onetomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    // bidirectional

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    private Set<CartItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CartItem> getItems() {
        if (items == null) {
            items = new HashSet<>();
        }

        return items;
    }

    public void addCartItem(CartItem item) {
        this.getItems().add(item);
    }

    public void removeCartItem(CartItem item) {
        this.items.remove(item);
    }
}
