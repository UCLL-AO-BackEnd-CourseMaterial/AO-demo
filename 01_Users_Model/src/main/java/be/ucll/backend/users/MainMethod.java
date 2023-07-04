package be.ucll.backend.users;

import be.ucll.backend.users.domain.User;
import be.ucll.backend.users.service.UserService;

public class MainMethod {
    public static void main(String[] args) {
        System.out.println("Hello World");

        String word = "abc";
        int number = 7;
        // number = "some text" // incorrect syntax

        User amelia = new User("Amelia", 44);
        User ben = new User("Ben", 5);
        User zeno = new User();

        System.out.println("Amelia has name " + amelia.getName() + " and age " + amelia.getAge());

        amelia.addMembershipYear(1990);
        amelia.addMembershipYear(2005);
        System.out.println("Memberships of Amelia after 1999: " + amelia.countMembershipYearsAfter1999());

        UserService userService = new UserService();
        System.out.println("Number of users in service: " + userService.getAllUsers().size());
        System.out.println("Oldest user is " + userService.getOldestUser().getName());
        System.out.println("There are " + userService.getUsersWithAgeOlderThan(20).size() + "users older than 20");

        // equality
        int a = 3;
        int b = 3;
        int c = 333;
        System.out.println("a and b are equal? ");
        System.out.println(a == b);
        System.out.println("a and c are equal? ");
        System.out.println(a == c);

        String first = "first";
        String second = "first";
        System.out.println(first == second);
        System.out.println(first.equals(second));

        User amelia1 = new User("Amelia", 44);
        User amelia2 = new User("Amelia", 44);
        System.out.println("Amelia1 is equal to Amelia2?");
        System.out.println(amelia1 == amelia2);
        System.out.println(amelia1.equals(amelia2));

    }
}
