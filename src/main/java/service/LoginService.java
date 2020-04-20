package service;

import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import model.User;

public class LoginService {
    private static final LoginService loginServiceinstance = new LoginService();
    EncryptionService encryptionService = EncryptionService.getInstance();
    UserService userService = UserService.getInstance();

    private LoginService() {}

    public static LoginService getInstance() {
        return loginServiceinstance;
    }

    public void login (String email, String password) throws EmailNotFoundException, WrongPasswordException {
        User existingUser = userService.getUserByEmail(email);

        if(existingUser == null)
            throw new EmailNotFoundException("User is not registered!");

        String decryptedPassword = encryptionService.decrypt(existingUser.getPassword());
        System.out.println(decryptedPassword);

        if (!decryptedPassword.equals(password))
            throw new WrongPasswordException("The password for this user is wrong!");

    }
}
