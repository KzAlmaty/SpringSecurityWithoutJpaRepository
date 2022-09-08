package ru.orazbakov.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.orazbakov.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepoImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(Role role) {
        entityManager.persist(role);
    }
}
