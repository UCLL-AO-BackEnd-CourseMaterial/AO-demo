package be.ucll.backend.users.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTestLabo {

    // given
    private String validNameAmelia = "Amelia";
    private int validAgeAmelia = 44;
    private String validEmailAmelia = "amelia.anderson@ucll.be";
    private String validPasswordAmelia = "ikgahetnietvertellenhoor";

    // //constructor
    // //happy case
    // @Test
    // void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
    // //when
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);

    // //then
    // assertNotNull(amelia);
    // assertEquals(validNameAmelia, amelia.getName());
    // assertEquals(validAgeAmelia, amelia.getAge());
    // assertEquals(0, amelia.countYearsOfMembership());
    // assertEquals(validEmailAmelia, amelia.getEmail());
    // assertEquals("@$-"+validPasswordAmelia+"&%#", amelia.getPassword());
    // }

    // //constructor
    // //unhappy case
    // //invalid negative age
    // @Test
    // void givenInvalidNegativeAge_whenCreatingUser_thenUserIsCreatedWithAge0() {
    // //when
    // User amelia = new User(validNameAmelia, -5, validEmailAmelia,
    // validPasswordAmelia);

    // //then
    // assertNotNull(amelia);
    // assertEquals(validNameAmelia, amelia.getName());
    // assertEquals(0, amelia.getAge());
    // assertEquals(0, amelia.countYearsOfMembership());
    // assertEquals(validEmailAmelia, amelia.getEmail());
    // assertEquals("@$-"+validPasswordAmelia+"&%#", amelia.getPassword());
    // }

    // //countMembershipYearsAfter1999
    // //happy case
    // @Test
    // void
    // givenUserWithMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_thenCorrectNumberIsReturned(){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);
    // amelia.addMembershipYear(2003);
    // amelia.addMembershipYear(1999);
    // amelia.addMembershipYear(2000);

    // //when
    // int result = amelia.countMembershipYearsAfter1999();

    // //then
    // assertEquals(2, result);
    // }

    // //countMembershipYearsAfter1999
    // //unhappy case
    // //no membership years after 1999
    // @Test
    // void
    // givenUserWithNoMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_then0IsReturned(){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);
    // amelia.addMembershipYear(1999);
    // amelia.addMembershipYear(1978);

    // //when
    // int result = amelia.countMembershipYearsAfter1999();

    // //then
    // assertEquals(0, result);
    // }

    // //constructor
    // //unhappy case
    // //invalid email (no @)
    // //TIP: go to the Java API to the String class and use the method contains
    // @Test
    // void givenInvalidEmail_whenCreatingUser_thenUserIsCreatedWithEmailNull() {
    // //when
    // User amelia = new User(validNameAmelia, validAgeAmelia,
    // "amelia.anderson.ucll.be", validPasswordAmelia);

    // //then
    // assertNotNull(amelia);
    // assertEquals(validNameAmelia, amelia.getName());
    // assertEquals(validAgeAmelia, amelia.getAge());
    // assertEquals(0, amelia.countYearsOfMembership());
    // assertNull(amelia.getEmail());
    // assertEquals("@$-"+validPasswordAmelia+"&%#", amelia.getPassword());
    // }

    // //constructor
    // //unhappy case
    // //invalid password (empty string)
    // //TIP: go to the Java API to the String class and use the method isBlank
    // @Test
    // void
    // givenInvalidPassword_whenCreatingUser_thenUserIsCreatedWithDefaultPasswordt()
    // {
    // //when
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia, "
    // ");

    // //then
    // assertNotNull(amelia);
    // assertEquals(validNameAmelia, amelia.getName());
    // assertEquals(validAgeAmelia, amelia.getAge());
    // assertEquals(0, amelia.countYearsOfMembership());
    // assertEquals(validEmailAmelia, amelia.getEmail());
    // assertEquals("@$-t&%#", amelia.getPassword());
    // }

    // //getFirstmembershipYear
    // //happy case
    // //TIP: go to the Java API to the ArrayList class and search for some methods
    // that you can use
    // @Test
    // void
    // givenUserWithMemberschipYears_whenAskForFirstMembershipYear_thenYearTheFarestInThePastIsReturned(){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);
    // amelia.addMembershipYear(2003);
    // amelia.addMembershipYear(1999);
    // amelia.addMembershipYear(2000);

    // //when
    // int firstMembershipYear = amelia.getFirstMembershipYear();

    // //then
    // assertEquals(1999, firstMembershipYear);
    // }

    // //getFirstmembershipYear
    // //unhappy case
    // //TIP: go to the Java API to the ArrayList class and search for some methods
    // that you can use
    // //no membership years
    // @Test
    // void
    // givenUserWithNoMemberschipYears_whenAskForFirstMembershipYear_then0IsReturned(){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);

    // //when
    // int firstMembershipYear = amelia.getFirstMembershipYear();

    // //then
    // assertEquals(0, firstMembershipYear);
    // }

    // //toString
    // //happy case
    // @Test
    // void
    // givenValidUser_whenToString_thenUserObjectisReturnedInStringRepresentation()
    // {
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);

    // //when
    // String result = amelia.toString();

    // //then
    // assertEquals("Amelia is 44 years old and has as email
    // amelia.anderson@ucll.be", result);
    // }

    // //getNumberOfMembershipYearsBetween2000And2999
    // //happy case
    // @Test
    // void
    // givenUserWithMemberschipYearsBetween2000And2999_whenAskForNumberOfMembershipYearsBetween2000And2999_thenCorrectNumberIsReturned(){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);
    // amelia.addMembershipYear(2003);
    // amelia.addMembershipYear(1999);
    // amelia.addMembershipYear(2000);
    // amelia.addMembershipYear(1978);
    // amelia.addMembershipYear(2023);

    // //when
    // int numberOfMembershipBetween2000And2999 =
    // amelia.getNumberOfMembershipYearsBetween2000And2999();

    // //then
    // assertEquals(3, numberOfMembershipBetween2000And2999);
    // }

    // //getNumberOfMembershipYearsBetween2000And2999
    // //unhappy case
    // @Test
    // void
    // givenUserWithNoMemberschipYearsBetween2000And2999_whenAskForNumberOfMembershipYearsBetween2000And2999_then0IsReturned(){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);
    // amelia.addMembershipYear(1980);
    // amelia.addMembershipYear(1999);
    // amelia.addMembershipYear(1978);
    // amelia.addMembershipYear(3000);

    // //when
    // int numberOfMembershipBetween2000And2999 =
    // amelia.getNumberOfMembershipYearsBetween2000And2999();

    // //then
    // assertEquals(0, numberOfMembershipBetween2000And2999);
    // }

    // //isPasswordCorrect
    // //happy case
    // // @Test
    // void
    // givenValidUser_whenCheckingPasswordWithCorrectPassword_thenTrueIsReturned (){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);

    // //when
    // boolean correctPassword =
    // amelia.isPasswordCorrect("ikgahetnietvertellenhoor");

    // //then
    // assertTrue(correctPassword);
    // }

    // //isPasswordCorrect
    // //unhappy case
    // @Test
    // void
    // givenValidUser_whenCheckingPasswordWithIncorrectPassword_thenFalseIsReturned
    // (){
    // //given
    // User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
    // validPasswordAmelia);

    // //when
    // boolean correctPassword = amelia.isPasswordCorrect("rararaaikgahet");

    // //then
    // assertFalse(correctPassword);
    // }
}