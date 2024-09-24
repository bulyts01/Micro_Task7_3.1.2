package ru.itmentor.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.models.Job;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        Optional<User> foundUser = userRepository.findById(id);

        return foundUser.orElse(null);
    }
    @Transactional
    public User saveUser(User saveUser) {
        saveUser.setJob(Job.SBER);
        saveUser.setCreatedAt(new Date());

        return userRepository.save(saveUser);
    }
    @Transactional
    public User updateUser(int id, User updateUser) {
        updateUser.setId(id);
        return userRepository.save(updateUser);
    }

    public void deleteUser(int id) {
        userRepository.delete(findUserById(id));
    }
}
