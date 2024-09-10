package org.example.page.page.object;

import io.qameta.allure.Step;
import lombok.Getter;
import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class ProfilePageObject extends BasePage {

    public final By LOGIN_FIELD = By.cssSelector("[value*='@']");
    public static final By LOGO = By.cssSelector("#root > div > header > nav > div > a > svg");
    public static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    public final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");

    @Step("click button in profile page")
    public void clickButton(WebDriver driver, By locator) {

        waitForVisibilityOfElement(driver, locator);
        driver.findElement(locator).click();

    }

}
