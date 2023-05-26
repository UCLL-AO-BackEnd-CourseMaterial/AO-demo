package be.ucll.backend.usersrestapiget;

import be.ucll.backend.usersrestapiget.domain.User;
import be.ucll.backend.usersrestapiget.service.UserService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service = new UserService();

    @Test
    void given4Users_whenNewUserIsAdded_thenUserIsAdded() {
        // given
        UserService service = new UserService();
        service.addUser(new User("Amelia", 44));
        service.addUser(new User("Ben", 15));
        service.addUser(new User("Charles", 65));
        service.addUser(new User("Diana", 13));
        assertEquals(4, service.getAllUsers().size());

        // when
        User amelia = new User("Amelia", 44);
        service.addUser(amelia);

        // then
        assertEquals(5, service.getAllUsers().size());
        assertTrue(service.getAllUsers().contains(amelia));
    }

    @Test
    void given4UsersWhere2UsersWithAge44_whenSearchForUsersOfAgeAfter43_then2UsersAreReturned() {
        // given
        UserService service = new UserService();
        service.addUser(new User("Amelia", 44));
        service.addUser(new User("Ben", 15));
        service.addUser(new User("Charles", 65));
        service.addUser(new User("Diana", 13));

        // when
        List<User> usersAged44 = service.getUsersWithAgeOlderThan(43);

        // then
        assertEquals(2, usersAged44.size());
        assertTrue(containsUserWithName(usersAged44, "Amelia"));
        assertTrue(containsUserWithName(usersAged44, "Charles"));
        assertFalse(containsUserWithName(usersAged44, "Ben"));
    }

    @Test
    void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() {
        // given
        UserService service = new UserService();
        service.addUser(new User("Amelia", 44));
        service.addUser(new User("Ben", 15));
        service.addUser(new User("Charles", 65));
        service.addUser(new User("Diana", 13));

        // when
        User oldestUser = service.getOldestUser();

        // then
        assertEquals(65, oldestUser.getAge());
        assertEquals("Charles", oldestUser.getName());
    }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }
}