package voronin.service;

import voronin.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getUserById(Long id);

    void saveUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, User user);

}
