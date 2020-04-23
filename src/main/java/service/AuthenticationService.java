package service;

import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import model.User;
import exceptions.ExistingUserException;

public class AuthenticationService {
    private static final AuthenticationService authenticationServiceInstance = new AuthenticationService();
    EncryptionService encryptionService = EncryptionService.getInstance();
    UserService userService = UserService.getInstance();

    private AuthenticationService() {}

    public static AuthenticationService getInstance() {
        return authenticationServiceInstance;
    }

    public void register(User user) throws ExistingUserException {
        String password = encryptionService.encrypt(user.getPassword());
        user.setPassword(password);

        User existingUser = userService.getUserByEmail(user.getEmail());

        if(existingUser != null)
            throw new ExistingUserException("User already registered!");

        userService.addUser(user);
    }

    public void login (String email, String password) throws EmailNotFoundException, WrongPasswordException {
        User existingUser = userService.getUserByEmail(email);

        if(existingUser == null)
            throw new EmailNotFoundException("This user is not registered!");

        String decryptedPassword = encryptionService.decrypt(existingUser.getPassword());
        if (!decryptedPassword.equals(password))
            throw new WrongPasswordException("The password for this user is wrong!");
    }
}
