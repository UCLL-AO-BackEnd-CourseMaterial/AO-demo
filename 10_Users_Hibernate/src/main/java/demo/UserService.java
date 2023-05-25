package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // public User getOldestUser() {
    //     User oldest = null;
    //     if (userRepository.size()>0) {
    //         oldest = userRepository.get(0);
    //         for (User user : userRepository) {
    //             if (user.getAge() > oldest.getAge())
    //                 oldest = user;
    //         }
    //     }
    //     return oldest;
    // }

    // public User getUserWithName(String name) {
    //     return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    // }

    public User addUser(User user) throws ServiceException {
        if (alreadyUserWithName(user.getName()))
            throw new ServiceException("name", "name already exists");
        return userRepository.save(user);
    }

    private boolean alreadyUserWithName (String name) {
        return userRepository.findByName(name)!=null;
    }

}
