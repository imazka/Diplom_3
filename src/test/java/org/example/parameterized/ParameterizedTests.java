package org.example.parameterized;

import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.example.BaseTest;
import org.example.page.page.ProfilePageObject;
import org.example.page.page.StartPageObject;
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
    @Description("параметризованный тест переходов по нажатию на логотип и кнопку \"Конструктор\"")
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

        startPageObject.clickEnterToPersonalAccountButton(driver);

        profilePageObject.clickButton(driver, element);

        waitForVisibilityOfElement(driver, StartPageObject.CREATE_BURGER_TEXTELEMENT);
        String expected = "Соберите бургер";
        String actual = driver.findElement(StartPageObject.CREATE_BURGER_TEXTELEMENT).getText();
        assertEquals(expected, actual);

    }

}
