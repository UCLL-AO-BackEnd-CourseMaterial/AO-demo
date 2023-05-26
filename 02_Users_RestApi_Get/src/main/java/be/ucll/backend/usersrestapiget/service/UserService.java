package be.ucll.backend.usersrestapiget.service;

import org.springframework.stereotype.Service;

import be.ucll.backend.usersrestapiget.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> userRepository = new ArrayList<>();

    public UserService() {
        User amelia = new User("Amelia", 44);
        User ben = new User("Ben", 15);
        User charles = new User("Charles", 65);
        User diana = new User("Diana", 13);
        addUser(amelia);
        addUser(ben);
        addUser(charles);
        addUser(diana);

    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge() > age).toList();
    }

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.size() > 0) {
            oldest = userRepository.get(0);
            for (User user : userRepository) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public User getUserWithName(String name) {
        if (userRepository.size() > 0)
            return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
        else
            return null;
    }

    public boolean addUser(User user) {
        return userRepository.add(user);
    }

}
