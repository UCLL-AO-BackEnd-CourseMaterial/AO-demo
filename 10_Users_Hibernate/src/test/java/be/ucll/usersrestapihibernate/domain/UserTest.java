package be.ucll.usersrestapihibernate.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    // constructor
    // happy case
    @Test
    void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
        // when
        User elke = new User("Elke", 45);

        // then
        assertNotNull(elke);
        assertEquals("Elke", elke.getName());
        assertEquals(45, elke.getAge());
        Set<ConstraintViolation<User>> violations = validator.validate(elke);
        assertTrue(violations.isEmpty());
    }

    // constructor
    // unhappy case
    // invalid negative age
    @Test
    void givenInvalidNegativeAge_whenCreatingUser_thenAgeViolationMessageIsThrown() {
        // when
        User eric = new User("Eric", -5);

        // then
        Set<ConstraintViolation<User>> violations = validator.validate(eric);
        assertEquals(violations.size(), 1);
        ConstraintViolation<User> violation = violations.iterator().next();
        assertEquals("age may not be negative", violation.getMessage());
        assertEquals("age", violation.getPropertyPath().toString());
        assertEquals(-5, violation.getInvalidValue());
    }

    // constructor
    // unhappy case
    // invalid empty name (" ")
    @Test
    void givenInvalidEmptyName_whenCreatingUser_thenNameViolationMessageIsThrown() {
        // when
        User eric = new User("    ", 65);

        // then
        Set<ConstraintViolation<User>> violations = validator.validate(eric);
        assertEquals(violations.size(), 1);
        ConstraintViolation<User> violation = violations.iterator().next();
        assertEquals("name may not be empty", violation.getMessage());
        assertEquals("name", violation.getPropertyPath().toString());
        assertEquals("    ", violation.getInvalidValue());
    }

    // constructor
    // unhappy case
    // invalid empty name ("")
    @Test
    void givenInvalidNoName_whenCreatingUser_thenNameViolationMessageIsThrown() {
        // when
        User eric = new User("", 65);

        // then
        Set<ConstraintViolation<User>> violations = validator.validate(eric);
        assertEquals(violations.size(), 1);
        ConstraintViolation<User> violation = violations.iterator().next();
        assertEquals("name may not be empty", violation.getMessage());
        assertEquals("name", violation.getPropertyPath().toString());
        assertEquals("", violation.getInvalidValue());
    }

}