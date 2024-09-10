package org.example.account.test;

import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalAccountTest extends BaseTest {

    //переход в личный кабинет
    @Test
    public void enterInProfilePageTest() {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));

        loginPageObject.openLoginPage(driver);
        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        sleep(2);
        userHomePageObject.clickEnterToPersonalAccountButton(driver);

        waitForVisibilityOfElement(driver, profilePageObject.LOGIN_FIELD);
        String expected = user.getEmail();
        String actual = driver.findElement(profilePageObject.LOGIN_FIELD).getAttribute("value");
        assertEquals(expected, actual);

    }

    //выход из аккаунта
    @Test
    public void exitAccountTest() {

        enterInProfilePageTest();

        profilePageObject.clickButton(driver, profilePageObject.EXIT_BUTTON);
        waitForVisibilityOfElement(driver, loginPageObject.ENTER_BUTTON);
        assertTrue(driver.findElement(loginPageObject.ENTER_BUTTON).isDisplayed());

    }

}
