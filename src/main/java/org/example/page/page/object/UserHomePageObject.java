package org.example.page.page.object;

import io.qameta.allure.Step;
import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHomePageObject extends BasePage {

    public final By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
    public final By ENTER_TO_PERSONAL_ACCOUNT_BUTTON = By.cssSelector("#root > div > header > nav > a > p");
    public final By CREATE_BURGER_TEXTELEMENT = By.xpath(".//h1[text()='Соберите бургер']");
    public final By FILLING_BUTTON = By.xpath(".//span[text()='Начинки']");
    public final By BUN_BUTTON = By.xpath(".//span[text()='Булки']");
    public final By SAUCE_BUTTON = By.xpath(".//span[text()='Соусы']");
    public final By SAUCE_IN_CONSTRUCTOR = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(4) > a:nth-child(1) > img");
    public final By FILLING_IN_CONSTRUCTOR = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(6) > a:nth-child(1) > img");
    public final By BUN_IN_CONSTRUCTOR = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(2) > a:nth-child(1) > img");

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

    @Step("element visibility check")
    public boolean checkVisibility(WebDriver driver, By locator) {

        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (Boolean) js.executeScript(
                "var element = arguments[0];" +
                        "var rect = element.getBoundingClientRect();" +
                        "return (rect.top >= 0 && rect.left >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
                element
        );

    }

}
