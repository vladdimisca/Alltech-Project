import exceptions.EmailNotFoundException;
import exceptions.WrongPasswordException;
import model.User;
import org.junit.jupiter.api.*;
import service.AuthenticationService;
import service.UserService;
import service.LoginService;

import exceptions.ExistingUserException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthenticationServiceTest {
    AuthenticationService authenticationService = AuthenticationService.getInstance();
    LoginService loginService = LoginService.getInstance();
    UserService userService = UserService.getInstance();

    String randomEmail = "dummy@mail.ro";
    User dummyUser = new User("first", "last", randomEmail, "dummy");

    @Test
    @Order(1)
    void newUserRegisterTest() {
        try {
            authenticationService.register(dummyUser);
        } catch (ExistingUserException e) {
            e.printStackTrace();
        }

        Boolean result = userService.getUserByEmail(randomEmail) != null;

        assertEquals(true, result, "Checking if user has been registered");
    }

    @Test
    @Order(2)
    void existingUserRegisterTest() {
        boolean result = false;

        try {
            authenticationService.register(dummyUser);
        } catch (ExistingUserException e) {
            result = true;
        }

        assertTrue(result, "Checking if user has been reported as existing");
    }

    @Test
    @Order(3)
    void loginTest() {
        boolean result = true;
        try {
            String randomPassword = dummyUser.getPassword();
            loginService.login(randomEmail, randomPassword);
        } catch (EmailNotFoundException | WrongPasswordException e) {
            result = false;
        }

        assertTrue(result, "Checking if email or password is correct");
    }

    @Test
    @Order(4)
    void removeUserTest() {
        userService.removeUserByEmail(randomEmail);

        boolean result = userService.getUserByEmail(randomEmail) == null;

        assertTrue(result, "Checking if user has been removed");
    }
}
