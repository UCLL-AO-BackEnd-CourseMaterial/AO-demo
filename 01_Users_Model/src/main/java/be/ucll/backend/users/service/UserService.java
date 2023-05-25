package be.ucll.backend.users.service;

import org.springframework.stereotype.Service;

import be.ucll.backend.users.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> userRepository = new ArrayList<>();

    public UserService() {
        User elke = new User("Elke", 44);
        User miyo = new User("Miyo", 15);
        User eric = new User("Eric", 65);
        User yuki = new User("Yuki", 13);
        addUser(elke);
        addUser(miyo);
        addUser(eric);
        addUser(yuki);

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
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        return userRepository.add(user);
    }

}
