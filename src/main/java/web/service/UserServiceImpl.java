package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.dao;
import web.model.Role;
import web.model.User;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements service {
    @Qualifier("userDaoImpl")
    @Autowired
    dao userDao;
    @Autowired
    RoleService roleService;

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void add(User user) {
        user.setRoles(Collections.singleton(roleService.getById(2L)));
        userDao.add(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public void addRole(String name, Long id) {
        User user = getByName(name);
        user.getRoles().add(roleService.getById(id));
        edit(user);
    }

    @Override
    public void deleteRole(String name, Long id) {
        User user = getByName(name);
        user.getRoles().remove(roleService.getById(id));
        edit(user);
    }
}
