package be.ucll.usersrestapipostjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ucll.usersrestapipostjpa.domain.User;
import be.ucll.usersrestapipostjpa.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    // private List<User> userRepository = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.findUsersByAgeAfter(age);
    }

    public User getOldestUser() {
        return userRepository.findFirstByOrderByAgeDesc();
    }

    public User getUserWithName(String name) {
        return userRepository.findUserByName(name);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

}
