package org.example.account;

import io.qameta.allure.Description;
import org.example.BaseTest;
import org.example.page.page.StartPageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorTest extends BaseTest {

    @Test
    @Description("тест видимости соусов при нажатии на кнопку \"Соусы\"")
    public void visibilitySauceTest() {

        startPageObject.openStartPage(driver);
        waitForVisibilityOfElement(driver, StartPageObject.SAUCE_BUTTON);
        startPageObject.clickSauceButton(driver);
        waitForVisibilityOfElement(driver, StartPageObject.CLICKED_BUTTON);
        assertEquals("Соусы", driver
                .findElement(StartPageObject.CLICKED_BUTTON)
                .findElement(By.xpath(".//span"))
                .getText());

    }

    @Test
    @Description("тест видимости начинок при нажатии на кнопку \"Начинки\"")
    public void visibilityFillingTest() {

        startPageObject.openStartPage(driver);
        waitForVisibilityOfElement(driver, StartPageObject.FILLING_BUTTON);
        startPageObject.clickFillingButton(driver);
        waitForVisibilityOfElement(driver, StartPageObject.CLICKED_BUTTON);
        assertEquals("Начинки", driver
                .findElement(StartPageObject.CLICKED_BUTTON)
                .findElement(By.xpath(".//span"))
                .getText());

    }

    @Test
    @Description("тест видимости булок при нажатии на кнопку \"Булки\"")
    public void visibilityBunsTest() {

        startPageObject.openStartPage(driver);
        waitForVisibilityOfElement(driver, StartPageObject.SAUCE_BUTTON);
        startPageObject.clickSauceButton(driver);
        startPageObject.clickBunButton(driver);
        waitForVisibilityOfElement(driver, StartPageObject.CLICKED_BUTTON);
        assertEquals("Булки", driver
                .findElement(StartPageObject.CLICKED_BUTTON)
                .findElement(By.xpath(".//span"))
                .getText());

    }

}
