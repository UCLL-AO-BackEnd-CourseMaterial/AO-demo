package be.ucll.usersrestapihibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ucll.usersrestapihibernate.domain.User;
import be.ucll.usersrestapihibernate.repo.UserRepository;

@Service
public class UserService {

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

    public User addUser(User user) throws ServiceException {
        if (getUserWithName(user.getName())!=null)
            throw new ServiceException("name", "name already exists");
        return userRepository.save(user);
    }


}
