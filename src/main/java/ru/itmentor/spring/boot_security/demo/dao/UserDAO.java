package ru.itmentor.spring.boot_security.demo.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDAO {
    private final EntityManager entityManager;

    @Autowired
    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);

//        // 1 Запрос
//        List<User> userList = session.createQuery("select u from User u", User.class).getResultList();
//
//        // N запросов к БД
//        for (User user : userList) {
//            System.out.println("User " + user.getName() + " has: " + user.getItems());

        // Solution
        // SQL: A LEFT JOIN B -> Результирующая избыточная объединенная таблица
        Set<User> userList = new HashSet<User>(session.createQuery("select u from User u LEFT JOIN FETCH u.items").getResultList());

        for (User user : userList) {
            System.out.println("User " + user.getName() + " has: " + user.getItems());
        }
    }
}
