package be.ucll.usersrestapihibernate.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import be.ucll.usersrestapihibernate.domain.User;
import be.ucll.usersrestapihibernate.repo.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void givenNoUsers_whenValidUserAdded_ThenUserIsAddedAndUserIsReturned() throws ServiceException {
        // given
        User amelia = new User("Amelia", 45);
        // mock all methods that are called in method that is tested here
        when(userRepository.save(amelia)).thenReturn(amelia);

        // when
        User addedUser = userService.addUser(amelia);

        // then
        assertEquals(amelia.getName(), addedUser.getName());

    }

    @Test
    public void givenUsersWhith1UserOlderThan20_whenGetUsersOlderThan20_thenListWith1UserOlderThan20IsReturned() {
        // given
        User amelia = new User("Amelia", 45);
        User ben = new User("Ben", 15);
        List<User> usersAbove20 = new ArrayList<User>();
        usersAbove20.add(amelia);
        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);

        // when
        List<User> result = userService.getUsersWithAgeOlderThan(20);

        // then
        assertEquals(usersAbove20.size(), result.size());
        assertTrue(result.contains(amelia));
        assertFalse(result.contains(ben));
    }

    @Test
    public void givenUsersWhithNoUsersOlderThan20_whenGetUsersOlderThan20_thenEmptyListIsReturned() {
        // given
        User ben = new User("Ben", 13);
        User diana = new User("Diana", 15);
        List<User> usersAbove20 = new ArrayList<User>();
        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);

        // when
        List<User> result = userService.getUsersWithAgeOlderThan(20);

        // then
        assertEquals(usersAbove20.size(), result.size());
        assertFalse(result.contains(ben));
        assertFalse(result.contains(diana));
    }

    @Test
    public void givenUsers_whenValidUserAddedWithAlreadyUsedName_ThenUserIsNotAddedAndErrorIsReturned() {
        // given
        User ben = new User("Ben", 45);
        User otherBen = new User("Ben", 45);

        when(userRepository.findUserByName(ben.getName())).thenReturn(ben);

        // when
        ServiceException ex = Assertions.assertThrows(ServiceException.class, () -> userService.addUser(otherBen));

        // then
        assertEquals("name", ex.getField());
        assertEquals("name already exists", ex.getMessage());
    }
}
