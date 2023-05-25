package be.ucll.usersrestapipostjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findUsersByAgeAfter(int age);   

}
