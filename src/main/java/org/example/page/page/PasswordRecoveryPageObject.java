package org.example.page.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPageObject {

    private static final String PASSWORD_RECOVERY_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private static final By ENTER_BUTTON = By.cssSelector("#root > div > main > div > div > p > a");

    @Step("click button \"Войти\" on password recovery page")
    public void clickEnterButton(WebDriver driver) {

        driver.findElement(ENTER_BUTTON).click();

    }

    @Step("open page password recovery")
    public void openPageRecoveryButton(WebDriver driver) {

        driver.get(PASSWORD_RECOVERY_PAGE_URL);

    }
}
