package org.example.page.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.example.page.BasePage;
import org.example.page.client.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Getter
public class RegistrationPageObject extends BasePage {

    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final By NAME_FIELD = By.xpath(".//label[text()='Имя']");
    public static final By EMAIL_FIELD = By.xpath(".//label[text()='Email']");
    public static final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']");
    public static final By REGISTRATION_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By INCORRECT_PASS_MESSAGE = By.xpath(".//p[text()='Некорректный пароль']");
    public static final By ENTER_BUTTON = By.cssSelector("#root > div > main > div > div > p > a");

    @Step("fill in the text fields on the registration page")
    public void setTextFields(WebDriver driver, User user) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(NAME_FIELD)).click().sendKeys(user.getName()).build().perform();
        actions.moveToElement(driver.findElement(EMAIL_FIELD)).click().sendKeys(user.getEmail()).build().perform();
        actions.moveToElement(driver.findElement(PASSWORD_FIELD)).click().sendKeys(user.getPassword()).build().perform();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(REGISTRATION_BUTTON));

    }

    @Step("click on the button \"Регистрация\" on the registration page")
    public void clickRegistrationButton(WebDriver driver) {

        driver.findElement(REGISTRATION_BUTTON).click();

    }

    @Step("click on the button \"Войти\" on registration page")
    public void clickEnterButton(WebDriver driver) {

        driver.findElement(ENTER_BUTTON).click();

    }

    @Step("open registration page with webdriver")
    public void openRegistrationPage(WebDriver driver) {

        driver.get(REGISTRATION_PAGE_URL);

    }

}
