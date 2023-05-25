package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        User elke = new User("Elke", 45);
        // mock all methods that are called in method that is tested here
        when(userRepository.save(any())).thenReturn(elke);

        // when
        User addedUser = userService.addUser(elke);

        // then
        assertThat(elke.getName()).isSameAs(addedUser.getName());
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

    @Test
    public void givenPatients_whenValidPatientAddedWithAlreadyUsedName_ThenPatientIsNotAddedAndErrorIsReturned() {
        // given
        User elke = new User("Elke", 45);
        User otherElke = new User("Elke", 45);

        when(userRepository.findByName(elke.getName())).thenReturn(elke);

        // when
        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.addUser(otherElke));
        
        // then
        assertEquals("name", ex.getField());    
        assertEquals("name already exists", ex.getMessage());
    }
}
