package org.example.account.test;

import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructorTest extends BaseTest {

    //тест переходов по разделам
    @Test
    public void transitionsTest() {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));

        loginPageObject.openLoginPage(driver);
        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        waitForVisibilityOfElement(driver, userHomePageObject.SAUCE_BUTTON);
        userHomePageObject.checkVisibility(driver, userHomePageObject.SAUCE_IN_CONSTRUCTOR);
        sleep(1);
        userHomePageObject.clickSauceButton(driver);
        sleep(1);
        assertTrue(userHomePageObject.checkVisibility(driver, userHomePageObject.SAUCE_IN_CONSTRUCTOR));

        waitForVisibilityOfElement(driver, userHomePageObject.FILLING_BUTTON);
        userHomePageObject.checkVisibility(driver, userHomePageObject.FILLING_IN_CONSTRUCTOR);
        sleep(1);
        userHomePageObject.clickFillingButton(driver);
        sleep(1);
        assertTrue(userHomePageObject.checkVisibility(driver, userHomePageObject.FILLING_IN_CONSTRUCTOR));

        waitForVisibilityOfElement(driver, userHomePageObject.BUN_BUTTON);
        userHomePageObject.checkVisibility(driver, userHomePageObject.BUN_IN_CONSTRUCTOR);
        sleep(1);
        userHomePageObject.clickBunButton(driver);
        sleep(1);
        assertTrue(userHomePageObject.checkVisibility(driver, userHomePageObject.BUN_IN_CONSTRUCTOR));

    }

}
