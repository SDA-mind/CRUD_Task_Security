package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Qualifier("userDaoImpl")
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleServiceImpl;

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void add(User user) {
        user.setRoles(Collections.singleton(roleServiceImpl.getById(2L)));
        userDao.add(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void edit(User user,String id) {
        userDao.edit(user,id);
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
        user.getRoles().add(roleServiceImpl.getById(id));
        edit(user,user.getName());
    }

    @Override
    public void deleteRole(String name, Long id) {
        User user = getByName(name);
        user.getRoles().remove(roleServiceImpl.getById(id));
        edit(user,user.getName());
    }
}
