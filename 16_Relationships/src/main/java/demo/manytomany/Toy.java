package demo.manytomany;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "favoriteToys")
    private Set<Dog> favoritedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Set<Dog> getFavoritedBy() {
    // if (favoritedBy == null) {
    // favoritedBy = new HashSet<>();
    // }

    // return favoritedBy;
    // }

    // public void addFavoritedBy(Dog dog) {
    // this.getFavoritedBy().add(dog);
    // }
}
