package demo.onetoone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    PersonRepo personRepo;

    @Mock
    AddressRepo addressRepo;

    @InjectMocks
    PersonService personService;

    private Person validPersonAlfred;
    private String personName = "Alfred";

    private Address validAddress;
    private String street = "Berkenlaan";
    private String number = "12";
    private String postalCode = "1000";
    private String town = "Brussels";

    @BeforeEach
    public void init() {
        validPersonAlfred = new Person();
        validPersonAlfred.setName(personName);

        validAddress = new Address();
        validAddress.setStreet(street);
        validAddress.setNumber(number);
        validAddress.setPostalCode(postalCode);
        validAddress.setTown(town);
    }

    @Test
    public void givenPersonWithNoAddress_whenValidAddressIsAdded_thenPersonHasAddress() {
        // given
        when(personRepo.findById(0L)).thenReturn(Optional.of(validPersonAlfred));
        when(personRepo.save(validPersonAlfred)).thenReturn(validPersonAlfred);
        when(addressRepo.save(validAddress)).thenReturn(validAddress);
        // when
        personService.addAddressToPerson(0L, validAddress);
        // then
        verify(personRepo).save(validPersonAlfred);
        verify(addressRepo).save(validAddress);
        assertEquals(validAddress, validPersonAlfred.getAddress());
    }

}
