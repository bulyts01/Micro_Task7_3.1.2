package ru.itmentor.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u")
    List<User> findAllUsers();
    List<User> findByName(String name);

    List<User> findByNameOrderByAge(String name);

    List<User> findByEmail(String email);

    List<User> findByNameStartingWith(String startWith);

    List<User> findByNameOrEmail(String name, String email);
}
