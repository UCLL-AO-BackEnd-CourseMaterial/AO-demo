package demo.onetoone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    private Person validPerson;
    private String personName = "Alfred";

    private Address validAddress;
    private String street = "Berkenlaan";
    private String number = "12";
    private String postalCode = "1000";
    private String town = "Brussels";

    @BeforeEach
    public void init() {
        validPerson = new Person();
        validPerson.setName(personName);

        validAddress = new Address();
        validAddress.setStreet(street);
        validAddress.setNumber(number);
        validAddress.setPostalCode(postalCode);
        validAddress.setTown(town);
    }

    @Test
    public void givenValidPersonAndAddres_whenAddressSetToPerson_thenPersonHasAddress() {
        validPerson.setAddress(validAddress);
        assertNotNull(validPerson.getAddress());
        assertEquals(validAddress.getStreet(), validPerson.getAddress().getStreet());
        assertEquals(validAddress.getTown(), validPerson.getAddress().getTown());
    }

}
