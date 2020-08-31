package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;
import web.service.RoleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl implements dao {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    RoleService roleService;

    @Autowired
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void add(User user) {
        user.setRoles(Collections.singleton(roleService.getById(2L)));
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.merge(user));
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByName(String name) {
        return entityManager.find(User.class, name);
    }
}
