package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDaoImpl;
import web.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDaoImpl roleDaoImpl;

    public List<Role> allRoles() {
        return roleDaoImpl.allRoles();
    }

    public void add(Role role) {
        roleDaoImpl.add(role);
    }

    public void delete(Role role) {
        roleDaoImpl.delete(role);
    }

    public void edit(Role role) {
        roleDaoImpl.edit(role);
    }

    public Role getById(Long id) {
        return roleDaoImpl.getById(id);
    }
}