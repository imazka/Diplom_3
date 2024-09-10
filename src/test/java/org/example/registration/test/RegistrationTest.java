package org.example.registration.test;

import io.qameta.allure.Description;
import org.example.BaseTest;
import org.example.page.page.LoginPageObject;
import org.example.page.page.RegistrationPageObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @Description("регистрация с позитивным сценарием")
    public void userRegistrationTest() {

        startPageObject.openStartPage(driver);
        startPageObject.clickEnterInAccountButton(driver);

        loginPageObject.clickRegistrationButton(driver);

        registrationPageObject.setTextFields(driver, user);
        registrationPageObject.clickRegistrationButton(driver);

        waitForVisibilityOfElement(driver, LoginPageObject.ENTER_BUTTON);
        assertTrue(driver.findElement(LoginPageObject.ENTER_BUTTON).isDisplayed());

    }

    @Test
    @Description("регистрация с невалидеым паролем")
    public void userRegWithIncorrectPassTest() {

        loginPageObject.openLoginPage(driver);
        loginPageObject.clickRegistrationButton(driver);

        user.setPassword(user.getPassword().substring(0, 4));
        registrationPageObject.setTextFields(driver, user);
        registrationPageObject.clickRegistrationButton(driver);

        waitForVisibilityOfElement(driver, RegistrationPageObject.INCORRECT_PASS_MESSAGE);
        assertTrue(driver.findElement(RegistrationPageObject.INCORRECT_PASS_MESSAGE).isDisplayed());

    }

}
