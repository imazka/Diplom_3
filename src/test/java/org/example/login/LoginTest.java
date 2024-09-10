package org.example.login;

import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.example.page.page.StartPageObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    @Description("вход по кнопке \"Личный кабинет\" на стартовой странице")
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

        waitForVisibilityOfElement(driver, startPageObject.CREATE_ORDER_BUTTON);

        assertTrue(driver.findElement(startPageObject.CREATE_BURGER_TEXTELEMENT).isDisplayed());

    }

    @Test
    @Description("вход по кнопке \"Войти\" на странице регистрации")
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

        waitForVisibilityOfElement(driver, StartPageObject.CREATE_ORDER_BUTTON);

        assertTrue(driver.findElement(StartPageObject.CREATE_BURGER_TEXTELEMENT).isDisplayed());

    }

    @Test
    @Description("вход по кнопке \"Войти\" на странице восстановления пароля")
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

        waitForVisibilityOfElement(driver, StartPageObject.CREATE_ORDER_BUTTON);

        assertTrue(driver.findElement(StartPageObject.CREATE_BURGER_TEXTELEMENT).isDisplayed());

    }

}
