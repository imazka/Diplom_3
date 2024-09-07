package org.example.login.test;

import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    //вход по кнопке "Личный кабинет" на стартовой странице
    @Test
    public void loginWithPersonalAccountButtonTest() {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));

        startPageObject.openStartPage(driver);
        startPageObject.clickPersonalAccountButton(driver);

        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        waitForVisibilityOfElement(driver, userHomePageObject.CREATE_ORDER_BUTTON);

        assertTrue(driver.findElement(userHomePageObject.CREATE_BURGER_TEXTELEMENT).isDisplayed());

    }

    //вход по кнопке "Войти" на странице регистрации
    @Test
    public void loginWithEnterButtonOnRegistrationPageTest() {

        registrationPageObject.openRegistrationPage(driver);
        registrationPageObject.clickEnterButton(driver);

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));
        user.setJwt(registrationResponse.extract().path("accessToken"));

        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        waitForVisibilityOfElement(driver, userHomePageObject.CREATE_ORDER_BUTTON);

        assertTrue(driver.findElement(userHomePageObject.CREATE_BURGER_TEXTELEMENT).isDisplayed());

    }

    //вход по кнопке "Войти" на странице восстановления пароля
    @Test
    public void loginWithEnterButtonOnPasswordRecoveryPageTest() {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));
        user.setJwt(registrationResponse.extract().path("accessToken"));

        passwordRecoveryPageObject.openPageRecoveryButton(driver);
        passwordRecoveryPageObject.clickEnterButton(driver);

        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        waitForVisibilityOfElement(driver, userHomePageObject.CREATE_ORDER_BUTTON);

        assertTrue(driver.findElement(userHomePageObject.CREATE_BURGER_TEXTELEMENT).isDisplayed());

    }

}
