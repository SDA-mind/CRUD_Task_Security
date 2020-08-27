package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements dao {
    private static Map<Integer, User> users = new HashMap<>();
    static int i = 3;
    static {

        User user1 = new User();
        user1.setId(1);
        user1.setName("Bob");
        user1.setLastName("White");
        user1.setDate("15/02/2000");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Sam");
        user2.setLastName("Green");
        user2.setDate("01/11/1980");
        users.put(user2.getId(), user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Clare");
        user3.setLastName("Jons");
        user3.setDate("10/05/1990");
        users.put(user3.getId(), user3);

    }
    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(++i);
        users.put(user.getId(),user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(),user);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }
}
