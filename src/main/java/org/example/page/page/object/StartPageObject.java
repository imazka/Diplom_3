package org.example.page.page.object;

import io.qameta.allure.Step;
import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPageObject extends BasePage {

    private By ENTER_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");

    private By PERSONAL_ACCOUNT_BUTTON = By.cssSelector("#root > div > header > nav > a > p");

    @Step("click on the button \"Личный кабинет\"")
    public void clickEnterInAccountButton(WebDriver driver) {

        driver.findElement(ENTER_ACCOUNT_BUTTON).click();

    }

    @Step("click on the button \"Личный кабинет\" on the start page")
    public void clickPersonalAccountButton(WebDriver driver) {

        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();

    }

    @Step("open start page with webdriver")
    public void openStartPage(WebDriver driver) {

        driver.get(START_PAGE_URL);

    }

}
