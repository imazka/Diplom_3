package org.example.registration.test;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {

    //регистрация с позитивным сценарием
    @Test
    public void userRegistrationTest() {

        startPageObject.openStartPage(driver);
        startPageObject.clickEnterInAccountButton(driver);

        loginPageObject.clickRegistrationButton(driver);

        registrationPageObject.setTextFields(driver, user);
        registrationPageObject.clickRegistrationButton(driver);

        waitForVisibilityOfElement(driver, loginPageObject.ENTER_BUTTON);
        assertTrue(driver.findElement(loginPageObject.ENTER_BUTTON).isDisplayed());

    }

    //регистрация с невалидеым паролем
    @Test
    public void userRegWithIncorrectPassTest() {

        loginPageObject.openLoginPage(driver);
        loginPageObject.clickRegistrationButton(driver);

        user.setPassword(user.getPassword().substring(0, 4));
        registrationPageObject.setTextFields(driver, user);
        registrationPageObject.clickRegistrationButton(driver);

        waitForVisibilityOfElement(driver, registrationPageObject.getINCORRECT_PASS_MESSAGE());
        assertTrue(driver.findElement(registrationPageObject.getINCORRECT_PASS_MESSAGE()).isDisplayed());

    }

}
