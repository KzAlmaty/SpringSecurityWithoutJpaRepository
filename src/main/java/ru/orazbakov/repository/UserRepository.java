package ru.orazbakov.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orazbakov.model.User;

import java.util.List;

@Repository
public interface UserRepository {

    @EntityGraph(attributePaths = {"roles"})
    User findByUsername(String username);

    User findByUsername(User user);

    public User getReferenceById(Long id);

    User findById(Long id);

    public void save(User user);

    List<User> findAll();

    public void deleteById(Long id);



}
