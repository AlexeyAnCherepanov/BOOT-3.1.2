package web.boot.service;

import web.boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User showUser(long id);

    void editUser(User user);

    void deleteUser(long id);
}
