package be.ucll.usersrestapipostjpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {

    // given
    private String validNameAmelia = "Amelia";
    private int validAgeAmelia = 44;

    // constructor
    // happy case
    @Test
    void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
        // when
        User elke = new User(validNameAmelia, validAgeAmelia);

        // then
        assertNotNull(elke);
        assertEquals(validNameAmelia, elke.getName());
        assertEquals(validAgeAmelia, elke.getAge());
        assertEquals(0, elke.countYearsOfMembership());
    }

    // constructor
    // unhappy case
    // invalid negative age
    @Test
    void givenInvalidNegativeAge_whenCreatingUser_thenUserIsCreatedWithAge0() {
        // when
        User elke = new User(validNameAmelia, -5);

        // then
        assertNotNull(elke);
        assertEquals(validNameAmelia, elke.getName());
        assertEquals(0, elke.getAge());
        assertEquals(0, elke.countYearsOfMembership());
    }

    // countMembershipYearsAfter1999
    // happy case
    @Test
    void givenUserWithMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_thenCorrectNumberIsReturned() {
        // given
        User elke = new User(validNameAmelia, validAgeAmelia);
        elke.addMembershipYear(2003);
        elke.addMembershipYear(1999);
        elke.addMembershipYear(2000);

        // when
        int result = elke.countMembershipYearsAfter1999();

        // then
        assertEquals(2, result);
    }

    // countMembershipYearsAfter1999
    // unhappy case
    // no membership years after 1999
    @Test
    void givenUserWithNoMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_then0IsReturned() {
        // given
        User elke = new User(validNameAmelia, validAgeAmelia);
        elke.addMembershipYear(1999);
        elke.addMembershipYear(1978);

        // when
        int result = elke.countMembershipYearsAfter1999();

        // then
        assertEquals(0, result);
    }

}