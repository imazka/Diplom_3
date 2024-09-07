package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static final String START_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    public void waitForVisibilityOfElement(WebDriver driver, By element) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void scrollToElement(WebDriver driver, By startOrderButtonBy) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(startOrderButtonBy));
    }

    public boolean checkPresenceToken(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jwt = (String) js.executeScript("return window.localStorage.getItem('accessToken');");

        return jwt == null;

    }

    public String getPresenceToken(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jwt = (String) js.executeScript("return window.localStorage.getItem('accessToken');");

        return jwt;

    }

}
