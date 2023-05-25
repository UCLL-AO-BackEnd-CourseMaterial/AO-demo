package demo.manytomany;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogTest {
    private Dog validDog;
    private String dogName = "Tommie";

    private Toy validToy;
    private String toyName = "ball";

    @BeforeEach
    public void init() {
        validDog = new Dog();
        validDog.setName(dogName);

        validToy = new Toy();
        validToy.setName(toyName);
    }

    @Test
    public void givenValidDogAndValidToy_whenToyIsAddedToDog_thenDogHasToy() {
        validDog.addToy(validToy);
        assertEquals(1, validDog.getFavoriteToys().size());
        assertTrue(validDog.getFavoriteToys().contains(validToy));
    }
}
