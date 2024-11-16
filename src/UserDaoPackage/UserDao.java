package UserDaoPackage;

import UserModel.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUser(int userId);
    void updateUser(User user);
    void deleteUser(int userId);
    List<User> getAllUsers();
}
