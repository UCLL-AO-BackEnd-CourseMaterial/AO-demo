package be.ucll.backend.users.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.ucll.backend.users.domain.User;

public class UserServiceTestLabo {
    UserService service = new UserService();
    User amelia, ben, charles, diana, emma;

    @BeforeEach
    public void setUp() {
        service = new UserService();
        service.getAllUsers().clear(); // remove all users added in constructor
        // amelia = new User("Amelia", 44, "amelia.anderson@ucll.be", "alpha");
        // ben = new User("Ben", 15, "ben.brown@ucll.be", "beta");
        // charles = new User("Charles", 65, "charles.clark@ucll.be", "gamma");
        // diana = new User("Diana", 13, "diana.davis@ucll.be", "delta");
        // emma = new User("Emma", 44, "emma.edwards@ucll.be", "epsilon");

    }

    // add: happy case
    // @Test
    // void given4Users_whenNewUserIsAdded_thenUserIsAdded() {
    // // given
    // service.addUser(amelia);
    // service.addUser(ben);
    // service.addUser(charles);
    // service.addUser(diana);
    // assertEquals(4, service.getAllUsers().size());

    // // when
    // service.addUser(emma);

    // // then
    // assertEquals(5, service.getAllUsers().size());
    // assertTrue(service.getAllUsers().contains(emma));
    // }

    // @Test
    // void given4Users_whenNewUserWithAlreadyUsedEmailIsAdded_thenUserIsNotAdded()
    // {
    // //given
    // assertEquals(4, serviceWithUsers.getAllUsers().size());

    // //when
    // User otherElke = new User("Elke", 20, "elke@ucll.be", "elkeelke");
    // boolean added = serviceWithUsers.addUser(otherElke);

    // //then
    // assertFalse(added);
    // assertEquals(4, serviceWithUsers.getAllUsers().size());
    // assertFalse(serviceWithUsers.getAllUsers().contains(otherElke));
    // assertTrue(serviceWithUsers.getAllUsers().contains(elke));
    // }

    // @Test
    // void
    // given4UsersWhere2UsersWithAge44_whenSearchForUsersOfAgeAfter43_then2UsersAreReturned()
    // {
    // // given
    // service.addUser(new User("Amelia", 44));
    // service.addUser(new User("Ben", 15));
    // service.addUser(new User("Charles", 65));
    // service.addUser(new User("Diana", 13));

    // // when
    // List<User> usersAged44 = service.getUsersWithAgeOlderThan(43);

    // // then
    // assertEquals(2, usersAged44.size());
    // assertTrue(containsUserWithName(usersAged44, "Amelia"));
    // assertTrue(containsUserWithName(usersAged44, "Charles"));
    // assertFalse(containsUserWithName(usersAged44, "Ben"));
    // }

    // @Test
    // void
    // given4UsersWhere0UsersWithAge80_whenSearchForUsersOlderThan80_thenAnEmpyListIsReturned()
    // {
    // //when
    // List<User> usersAged81 = serviceWithUsers.getUsersWithAgeOlderThan(80);

    // //then
    // assertEquals(0, usersAged81.size());
    // }

    // @Test
    // void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() {
    // // given
    // service.addUser(new User("Amelia", 44));
    // service.addUser(new User("Ben", 15));
    // service.addUser(new User("Charles", 65));
    // service.addUser(new User("Diana", 13));

    // // when
    // User oldestUser = service.getOldestUser();

    // // then
    // assertEquals(65, oldestUser.getAge());
    // assertEquals("Charles", oldestUser.getName());
    // }

    // @Test
    // void givenNoUsers_whenSearchForOldestUser_thenNullValueIsReturned() {
    // //when
    // User oldestUser = serviceWithoutUsers.getOldestUser();

    // //then
    // assertNull(oldestUser);
    // }

    // @Test
    // void given4Users_whenSearchForUserWithNameCharles_thenUserCharlesIsReturned()
    // {
    // // given
    // service.addUser(new User("Amelia", 44));
    // service.addUser(new User("Ben", 15));
    // service.addUser(new User("Charles", 65));
    // service.addUser(new User("Diana", 13));

    // // when
    // User userCharles = service.getUserWithName("Charles");

    // // then
    // assertNotNull(userCharles);
    // assertEquals("Charles", userCharles.getName());

    // }

    // @Test
    // void givenEmptyService_whenSearchForUserWithNameCharles_thenNullIsReturned()
    // {
    // // when
    // User userCharles = service.getUserWithName("Charles");

    // // then
    // assertNull(userCharles);
    // }

    // @Test
    // void given4Users_whenSearchForUserWithExistingEmail_thenUserIsReturned() {
    // //when
    // User foundUser = serviceWithUsers.getUserWithEmail("ben.brown@ucll.be");

    // //then
    // assertEquals(15, foundUser.getAge());
    // assertEquals("Ben", foundUser.getName());
    // }

    // @Test
    // void given4Users_whenSearchForUserWithNonExistingEmail_thenNullIsReturned() {
    // //when
    // User foundUser = serviceWithUsers.getUserWithEmail("paul.peterson@ucll.be");

    // //then
    // assertNull(foundUser);
    // }

    // @Test
    // void
    // given4Users_whenRemoveExistingUser_thenUserIsRemovedAndRemovedUserIsReturned()
    // {
    // //given
    // assertEquals(4, serviceWithUsers.getAllUsers().size());

    // //when
    // User removedUser = serviceWithUsers.removeUser("ben.brown@ucll.be");

    // //then
    // assertEquals(3, serviceWithUsers.getAllUsers().size());
    // assertEquals(13, removedUser.getAge());
    // assertEquals("Ben", removedUser.getName());
    // }

    // @Test
    // void
    // given4Users_whenRemoveNonExistingUser_thenUserIsNotRemovedAndNullValueIsReturned()
    // {
    // //given
    // assertEquals(4, serviceWithUsers.getAllUsers().size());

    // //when
    // User removedUser = serviceWithUsers.removeUser("paul.peterson@ucll.be");

    // //then
    // assertEquals(4, serviceWithUsers.getAllUsers().size());
    // assertNull(removedUser);
    // }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }
}
