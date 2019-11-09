package com.epam.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class JavaScriptExecutor {
    private WebDriverWait driverWait;
    private WebDriver driver;

    public JavaScriptExecutor(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public void waitForJQueryLoad() {
        ExpectedCondition<Boolean> jQueryLoad = driver ->
                (Long) ((JavascriptExecutor) Objects.requireNonNull(driver)).executeScript(("return jQuery.active")) == 0;
        driverWait.until(jQueryLoad);
    }

    public void waitForJsLoad() {
        ExpectedCondition<Boolean> jsLoad = driver ->
                ((JavascriptExecutor) Objects.requireNonNull(driver)).executeScript(("return document.readyState")).equals("complete");
        driverWait.until(jsLoad);
    }

    public void scrollIntoElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
