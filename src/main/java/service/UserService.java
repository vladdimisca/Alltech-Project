package service;

import model.User;
import repository.UserRepository;

public class UserService {
    private static final UserService userServiceInstance = new UserService();
    UserRepository userRepository = UserRepository.getInstance();

    private UserService() {}

    public static UserService getInstance() {
        return userServiceInstance;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void removeUserByEmail(String email) {
        userRepository.removeUserByEmail(email);
    }
}
