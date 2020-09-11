package web.dao;

import org.springframework.stereotype.Component;
import web.model.Role;

import java.util.List;

@Component
public interface RoleDao {
    List<Role> allRoles();

    void add(Role role);

    void delete(Role role);

    void edit(Role role);

    Role getById(Long id);
}
