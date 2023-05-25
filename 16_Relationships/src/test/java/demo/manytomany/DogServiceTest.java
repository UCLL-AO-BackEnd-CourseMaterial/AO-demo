package demo.manytomany;

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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {

    @Mock
    DogRepo dogRepo;

    @Mock
    ToyRepo toyRepo;

    @InjectMocks
    DogService dogService;

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
    public void givenDogWithoutToys_whenValidToyIsAdded_thenDogHasToy() {
        // given
        when(dogRepo.findById(0L)).thenReturn(Optional.of( validDog));
        when(dogRepo.save(validDog)).thenReturn(validDog);
        when(toyRepo.save(validToy)).thenReturn(validToy);
        // when
        dogService.addToyToDog(0L, validToy);
        // then
        assertEquals(1, validDog.getFavoriteToys().size());
        assertTrue(validDog.getFavoriteToys().contains(validToy));
        verify(dogRepo).save(validDog);
        verify(toyRepo).save(validToy);
    }

}
