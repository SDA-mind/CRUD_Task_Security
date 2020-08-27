package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;
@Component
public interface dao {
    List<User> allUsers();
    void add(User film);
    void delete(User film);
    void edit(User film);
    User getById(int id);
}
