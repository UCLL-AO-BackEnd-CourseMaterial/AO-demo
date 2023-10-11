package be.ucll.usersrestapipostjpa;

import org.junit.jupiter.api.Test;

import be.ucll.usersrestapipostjpa.domain.User;

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
        User amelia = new User(validNameAmelia, validAgeAmelia);

        // then
        assertNotNull(amelia);
        assertEquals(validNameAmelia, amelia.getName());
        assertEquals(validAgeAmelia, amelia.getAge());
        assertEquals(0, amelia.countYearsOfMembership());
    }

    // constructor
    // unhappy case
    // invalid negative age
    @Test
    void givenInvalidNegativeAge_whenCreatingUser_thenUserIsCreatedWithAge0() {
        // when
        User amelia = new User(validNameAmelia, -5);

        // then
        assertNotNull(amelia);
        assertEquals(validNameAmelia, amelia.getName());
        assertEquals(0, amelia.getAge());
        assertEquals(0, amelia.countYearsOfMembership());
    }

    // countMembershipYearsAfter1999
    // happy case
    @Test
    void givenUserWithMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_thenCorrectNumberIsReturned() {
        // given
        User amelia = new User(validNameAmelia, validAgeAmelia);
        amelia.addMembershipYear(2003);
        amelia.addMembershipYear(1999);
        amelia.addMembershipYear(2000);

        // when
        int result = amelia.countMembershipYearsAfter1999();

        // then
        assertEquals(2, result);
    }

    // countMembershipYearsAfter1999
    // unhappy case
    // no membership years after 1999
    @Test
    void givenUserWithNoMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_then0IsReturned() {
        // given
        User amelia = new User(validNameAmelia, validAgeAmelia);
        amelia.addMembershipYear(1999);
        amelia.addMembershipYear(1978);

        // when
        int result = amelia.countMembershipYearsAfter1999();

        // then
        assertEquals(0, result);
    }

}