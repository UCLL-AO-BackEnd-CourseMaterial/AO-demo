package be.ucll.usersrestapipostjpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void givenNoUsers_whenValidUserAdded_ThenUserIsAddedAndUserIsReturned() {
        // given
        User elke = new User("Elke", 45);
        // mock all methods that are called in method that is tested here
        when(userRepository.save(elke)).thenReturn(elke);

        // when
        User addedUser = userService.addUser(elke);

        // then
        assertEquals(elke.getName(), addedUser.getName());
    }

    @Test
    public void givenUsersWhith1UserOlderThan20_whenGetUsersOlderThan20_thenListWith1UserOlderThan20IsReturned() {
        //given
        User elke = new User("Elke", 45);
        User miyo = new User("Miyo", 15);
        List<User> usersAbove20 = new ArrayList<User>();
        usersAbove20.add(elke);
        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);

        //when
        List<User> result = userService.getUsersWithAgeOlderThan(20);

        //then
        assertEquals(usersAbove20.size(), result.size());
        assertTrue(result.contains(elke));
        assertFalse(result.contains(miyo));
    }

    @Test
    public void givenUsersWhithNoUsersOlderThan20_whenGetUsersOlderThan20_thenEmptyListIsReturned() {
        //given
        User yuki = new User("Yuki", 13);
        User miyo = new User("Miyo", 15);
        List<User> usersAbove20 = new ArrayList<User>();
        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);

        //when
        List<User> result = userService.getUsersWithAgeOlderThan(20);

        //then
        assertEquals(usersAbove20.size(), result.size());
        assertFalse(result.contains(yuki));
        assertFalse(result.contains(miyo));
    }
}