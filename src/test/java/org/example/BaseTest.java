package org.example;

import io.restassured.response.ValidatableResponse;
import org.example.page.BasePage;
import org.example.page.client.User;
import org.example.page.client.UserClient;
import org.example.page.page.object.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends BasePage {

    protected User user;
    protected UserClient userClient;
    protected static WebDriver driver;
    protected LoginPageObject loginPageObject;
    protected StartPageObject startPageObject;
    protected ProfilePageObject profilePageObject;
    protected UserHomePageObject userHomePageObject;
    protected ValidatableResponse registrationResponse;
    protected RegistrationPageObject registrationPageObject;
    protected PasswordRecoveryPageObject passwordRecoveryPageObject;

    protected static WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

    @BeforeEach
    public void setUpDriver() {

        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.manage().window().maximize();

        user = new User();
        userClient = new UserClient();
        startPageObject = new StartPageObject();
        loginPageObject = new LoginPageObject();
        profilePageObject = new ProfilePageObject();
        userHomePageObject = new UserHomePageObject();
        registrationPageObject = new RegistrationPageObject();
        passwordRecoveryPageObject = new PasswordRecoveryPageObject();

    }

    @AfterEach
    public void afterEachSetUp() {

        try {

            //удаление зарегистрированного юзера
            userClient.deleteUser(user.getJwt());

        } catch (Exception ignored) {}

        driver.close();

    }

    public void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}