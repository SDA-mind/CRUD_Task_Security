package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public interface service {
    List<User> allUsers();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(int id);

    User getByName(String name);
}
