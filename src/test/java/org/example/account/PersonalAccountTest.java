package org.example.account;

import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.example.page.page.LoginPageObject;
import org.example.page.page.ProfilePageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalAccountTest extends BaseTest {

    @Test
    @Description("выход из аккаунта")
    public void exitAccountTest() {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));

        loginPageObject.openLoginPage(driver);

        moveAndClickToElement(driver, LoginPageObject.EMAIL_FIELD);

        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        startPageObject.clickEnterToPersonalAccountButton(driver);

        waitForVisibilityOfElement(driver, ProfilePageObject.PROFILE_LIST_FIELD);

        assertTrue(driver.findElement(ProfilePageObject.PROFILE_LIST_FIELD).getText().contains("Логин"));

        profilePageObject.clickButton(driver, ProfilePageObject.EXIT_BUTTON);
        waitForVisibilityOfElement(driver, LoginPageObject.ENTER_BUTTON);
        assertTrue(driver.findElement(LoginPageObject.ENTER_BUTTON).isDisplayed());

    }

    @Test
    @Description("переход в личный кабинет")
    public void enterInProfilePageTest() {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));

        loginPageObject.openLoginPage(driver);

        moveAndClickToElement(driver, LoginPageObject.EMAIL_FIELD);

        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        startPageObject.clickEnterToPersonalAccountButton(driver);

        waitForVisibilityOfElement(driver, ProfilePageObject.PROFILE_LIST_FIELD);

        assertTrue(driver.findElement(ProfilePageObject.PROFILE_LIST_FIELD).getText().contains("Логин"));

    }

}
