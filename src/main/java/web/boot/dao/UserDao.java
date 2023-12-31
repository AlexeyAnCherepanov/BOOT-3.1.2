package web.boot.dao;

import web.boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void save(User user);

    User showUser(long id);

    void editUser(User user);

    void deleteUser(long id);
}
