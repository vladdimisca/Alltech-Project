package service;

import model.User;
import exceptions.ExistingUserException;

public class AuthenticationService {
    private static final AuthenticationService authenticationServiceinstance = new AuthenticationService();
    EncryptionService encryptionService = EncryptionService.getInstance();
    UserService userService = UserService.getInstance();

    private AuthenticationService() {}

    public static AuthenticationService getInstance() {
        return authenticationServiceinstance;
    }

    public void register(User user) throws ExistingUserException {
        String password = encryptionService.encrypt(user.getPassword());
        user.setPassword(password);

        User existingUser = userService.getUserByEmail(user.getEmail());

        if(existingUser != null)
            throw new ExistingUserException("User already registered!");

        userService.addUser(user);
    }
}
