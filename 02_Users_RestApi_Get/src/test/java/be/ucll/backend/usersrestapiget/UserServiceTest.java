package be.ucll.backend.usersrestapiget;

import be.ucll.backend.usersrestapiget.User;
import be.ucll.backend.usersrestapiget.UserService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service = new UserService();

    @Test
    void given4Users_whenNewUserIsAdded_thenUserIsAdded() {
        //given
        UserService service = new UserService();
        service.addUser(new User("Elke", 44));
        service.addUser(new User("Miyo", 15));
        service.addUser(new User("Eric", 65));
        service.addUser(new User("Yuki", 13));
        assertEquals(4, service.getAllUsers().size());

        //when
        User elke = new User("Elke", 44);
        service.addUser(elke);

        //then
        assertEquals(5, service.getAllUsers().size());
        assertTrue(service.getAllUsers().contains(elke));
    }

    @Test
    void given4UsersWhere2UsersWithAge44_whenSearchForUsersOfAgeAfter43_then2UsersAreReturned() {
        //given
        UserService service = new UserService();
        service.addUser(new User("Elke", 44));
        service.addUser(new User("Miyo", 15));
        service.addUser(new User("Eric", 65));
        service.addUser(new User("Yuki", 13));

        //when
        List<User> usersAged44 = service.getUsersWithAgeOlderThan(43);

        //then
        assertEquals(2, usersAged44.size());
        assertTrue(containsUserWithName(usersAged44, "Elke"));
        assertTrue(containsUserWithName(usersAged44, "Eric"));
        assertFalse(containsUserWithName(usersAged44, "Miyo"));
    }

    @Test
    void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() {
        //given
        UserService service = new UserService();
        service.addUser(new User("Elke", 44));
        service.addUser(new User("Miyo", 15));
        service.addUser(new User("Eric", 65));
        service.addUser(new User("Yuki", 13));

        //when
        User oldestUser = service.getOldestUser();

        //then
        assertEquals(65, oldestUser.getAge());
        assertEquals("Eric", oldestUser.getName());
    }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }
}