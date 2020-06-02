import exceptions.ExistingUserException;
import exceptions.WrongPasswordException;
import model.User;
import org.junit.jupiter.api.*;
import service.EncryptionService;
import service.UserService;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    UserService userService = UserService.getInstance();

    String randomEmail = "dummy@mail.ro";
    String randomPassword = "dummy";
    User dummyUser = new User("first", "last", randomEmail, EncryptionService.getInstance().encrypt(randomPassword));
    String newPassword = "newDummy";
    String newEmail = "new@mail.ccm";

    @Test
    @Order(1)
    void addAndGetUserTest() {
        boolean result = true;

        userService.addUser(dummyUser);

        User user = userService.getUserByEmail(randomEmail);

        if(user == null || !user.equals(dummyUser))
            result = false;

        assertTrue(result, "Checking if user has been added and can be retrieved");
    }

    @Test
    @Order(2)
    void changePasswordTest() {
        try {
            userService.changePassword(randomEmail, randomPassword, newPassword);
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        String encryptedPass = userService.getUserByEmail(randomEmail).getPassword();

        String decryptedPass = EncryptionService.getInstance().decrypt(encryptedPass);

        boolean result = decryptedPass.equals(newPassword);

        assertTrue(result, "Checking if password has been changed");
    }

    @Test
    @Order(3)
    void FailToChangePasswordTest() {
        String wrongPassword = "wrongDummy";
        String newPass = "pass";

        boolean result = false;

        try {
            userService.changePassword(randomEmail, wrongPassword, newPass);
        } catch (WrongPasswordException e) {
            result = true;
        }

        assertTrue(result, "Checking if password exception has been thrown");
    }

    @Test
    @Order(4)
    void changeFirstNameTest() {
        String newFirstName = "newDummy";

        userService.changeFirstName(randomEmail, newFirstName);

        boolean result = userService.getUserByEmail(randomEmail).getFirstName().equals(newFirstName);

        assertTrue(result, "Checking if first name has been changed");
    }

    @Test
    @Order(6)
    void changeLastNameTest() {
        String newLastName = "newDummy";

        userService.changeLastName(randomEmail, newLastName);

        boolean result = userService.getUserByEmail(randomEmail).getLastName().equals(newLastName);

        assertTrue(result, "Checking if last name has been changed");
    }

    @Test
    @Order(7)
    void changeEmailTest() {
        try {
            userService.changeEmail(randomEmail, newEmail);
        } catch (ExistingUserException e) {
            e.printStackTrace();
        }

        boolean result = userService.getUserByEmail(newEmail) != null;

        assertTrue(result, "Checking if email has been changed");
    }

    @Test
    @Order(8)
    void removeUserTest() {
        try {
            userService.removeUserByEmail(newEmail, newPassword);
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        boolean result = userService.getUserByEmail(randomEmail) == null;

        assertTrue(result, "Checking if user has been removed");
    }
}
