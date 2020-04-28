package service;

import exceptions.ExistingUserException;
import exceptions.WrongPasswordException;
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

    public void changePassword (String email, String oldPassword, String newPassword) throws WrongPasswordException {
        EncryptionService encryptionService = EncryptionService.getInstance();

        String decryptedPassword = encryptionService.decrypt(getUserByEmail(email).getPassword());

        if (!decryptedPassword.equals(oldPassword))
            throw new WrongPasswordException("The password for this user is wrong!");

        userRepository.changePassword(email, newPassword);

    }

    public void changeFirstName (String email, String newName) {
        userRepository.changeFirstName(email, newName);
    }

    public  void changeLastName (String email, String newName) {
        userRepository.changeLastName(email, newName);
    }

    public void changeEmail (String email, String newEmail) throws ExistingUserException {
        if(getUserByEmail(newEmail) != null)
            throw new ExistingUserException("This email is already used!");

        userRepository.changeEmail(email, newEmail);
    }
}
