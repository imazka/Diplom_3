package org.example.page.page;

import io.qameta.allure.Step;
import org.example.page.BasePage;
import org.example.page.client.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPageObject extends BasePage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final By EMAIL_FIELD = By.xpath(".//label[text()='Email']");
    public static final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']");
    public static final By ENTER_BUTTON = By.cssSelector("#root > div > main > div > form > button");
    public static final By REGISTRATION_BUTTON = By.xpath(".//a[text()='Зарегистрироваться']");

    @Step("click on the button \"Зарегистрироваться\" on the login page")
    public void clickRegistrationButton(WebDriver driver) {

        driver.findElement(REGISTRATION_BUTTON).click();

    }

    @Step("click on the button \"Войти\" on the login page")
    public void clickEnterButton(WebDriver driver, User user) {

        driver.findElement(ENTER_BUTTON).click();
        user.setJwt(getPresenceToken(driver));

    }

    @Step("fill in the text fields on the login page")
    public void setTextFields(WebDriver driver, String email, String password) {

        waitForVisibilityOfElement(driver, ENTER_BUTTON);
        scrollToElement(driver, EMAIL_FIELD);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(EMAIL_FIELD)).click().sendKeys(email).build().perform();
        actions.moveToElement(driver.findElement(PASSWORD_FIELD)).click().sendKeys(password).build().perform();

    }

    @Step("open login page")
    public void openLoginPage(WebDriver driver) {

        driver.get(LOGIN_PAGE_URL);

    }

}
