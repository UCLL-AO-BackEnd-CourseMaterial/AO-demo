package be.ucll.usersrestapihibernate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ucll.usersrestapihibernate.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findUsersByAgeAfter(int age);

    public User findUserByName(String name);

    public User findFirstByOrderByAgeDesc();

}
