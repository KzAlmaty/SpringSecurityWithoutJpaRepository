package ru.orazbakov.repository;

import org.springframework.stereotype.Repository;
import ru.orazbakov.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    public User findByUsername(User user) {
        return entityManager.find(User.class, user);
    }

    @Override
    public User getReferenceById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
