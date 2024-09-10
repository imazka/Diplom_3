package org.example.page.page;

import io.qameta.allure.Step;
import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPageObject extends BasePage {

    private static final By ENTER_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By PERSONAL_ACCOUNT_BUTTON = By.cssSelector("#root > div > header > nav > a > p");
    public static final By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
    public static final By ENTER_TO_PERSONAL_ACCOUNT_BUTTON = By.cssSelector("#root > div > header > nav > a > p");
    public static final By CREATE_BURGER_TEXTELEMENT = By.xpath(".//h1[text()='Соберите бургер']");
    public static final By FILLING_BUTTON = By.xpath(".//span[text()='Начинки']");
    public static final By BUN_BUTTON = By.xpath(".//span[text()='Булки']");
    public static final By SAUCE_BUTTON = By.xpath(".//span[text()='Соусы']");
    public static final By CLICKED_BUTTON = By.xpath(".//div[@class ='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");


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

    @Step("click button \"Личный кабинет\" in user home page")
    public void clickEnterToPersonalAccountButton(WebDriver driver) {

        waitForVisibilityOfElement(driver, ENTER_TO_PERSONAL_ACCOUNT_BUTTON);
        driver.findElement(ENTER_TO_PERSONAL_ACCOUNT_BUTTON).click();

    }

    @Step("click button \"Булки\" on user home page")
    public void clickBunButton(WebDriver driver) {

        driver.findElement(BUN_BUTTON).click();

    }

    @Step("click button \"Начинки\" on user home page")
    public void clickFillingButton(WebDriver driver) {

        driver.findElement(FILLING_BUTTON).click();

    }

    @Step("click button \"Булки\" on user home page")
    public void clickSauceButton(WebDriver driver) {

        driver.findElement(SAUCE_BUTTON).click();

    }

}
