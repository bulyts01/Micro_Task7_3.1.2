package ru.itmentor.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmentor.spring.boot_security.demo.models.User;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends JpaRepository<User, Integer> {

}
