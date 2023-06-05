package be.ucll.usersrestapipostjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.ucll.usersrestapipostjpa.domain.User;
import be.ucll.usersrestapipostjpa.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // @GetMapping("/oldest")
    // public User getOldestUser() {
    // return userService.getOldestUser();
    // }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) {
        return userService.getUsersWithAgeOlderThan(age);
    }

    // @GetMapping("/search/{name}")
    // public User searchUserWithName(@PathVariable("name") String name) {
    // return userService.getUserWithName(name);
    // }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
