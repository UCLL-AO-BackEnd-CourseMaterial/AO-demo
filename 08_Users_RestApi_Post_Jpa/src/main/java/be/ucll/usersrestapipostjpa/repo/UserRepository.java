package be.ucll.usersrestapipostjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ucll.usersrestapipostjpa.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findUsersByAgeAfter(int age);

    public User findUserByName(String name);

    public User findFirstByOrderByAgeDesc();

}
