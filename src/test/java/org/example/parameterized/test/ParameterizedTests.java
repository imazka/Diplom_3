package org.example.parameterized.test;

import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.example.page.page.object.ProfilePageObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParameterizedTests extends BaseTest {

    static Stream<Arguments> pageElements() {

        return Stream.of(
                Arguments.of(ProfilePageObject.LOGO),
                Arguments.of(ProfilePageObject.CONSTRUCTOR_BUTTON)
        );
    }

    @ParameterizedTest
    @MethodSource("pageElements")
    void testPageElements(By element) {

        registrationResponse = userClient.createUser(user);
        assertEquals(HttpStatus.SC_OK, registrationResponse.extract().statusCode());
        assertEquals(user.getName(), registrationResponse.extract().path("user.name"));
        assertNotNull(registrationResponse.extract().path("accessToken"));
        assertNotNull(registrationResponse.extract().path("refreshToken"));
        user.setJwt(registrationResponse.extract().path("accessToken"));

        loginPageObject.openLoginPage(driver);
        loginPageObject.setTextFields(driver, user.getEmail(), user.getPassword());
        loginPageObject.clickEnterButton(driver, user);

        userHomePageObject.clickEnterToPersonalAccountButton(driver);

        waitForVisibilityOfElement(driver, profilePageObject.LOGIN_FIELD);
        String expected = user.getEmail();
        String actual = driver.findElement(profilePageObject.LOGIN_FIELD).getAttribute("value");
        assertEquals(expected, actual);

        profilePageObject.clickButton(driver, element);

        waitForVisibilityOfElement(driver, userHomePageObject.CREATE_BURGER_TEXTELEMENT);
        expected = "Соберите бургер";
        actual = driver.findElement(userHomePageObject.CREATE_BURGER_TEXTELEMENT).getText();
        assertEquals(expected, actual);

    }

}
