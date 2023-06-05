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

    // public User getOldestUser() {
    // User oldest = null;
    // if (userRepository.size()>0) {
    // oldest = userRepository.get(0);
    // for (User user : userRepository) {
    // if (user.getAge() > oldest.getAge())
    // oldest = user;
    // }
    // }
    // return oldest;
    // }

    // public User getUserWithName(String name) {
    // return userRepository.stream().filter(user ->
    // user.getName().equals(name)).toList().get(0);
    // }

    public User addUser(User user) {
        return userRepository.save(user);
    }

}
