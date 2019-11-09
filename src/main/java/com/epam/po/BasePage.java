package com.epam.po;

import com.epam.utils.JavaScriptExecutor;
import com.epam.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected JavaScriptExecutor javaScriptExecutor;

    public BasePage() {
        initDrivers();
        PageFactory.initElements(driver, this);
    }

    private void initDrivers() {
        driver = WebDriverManager.getDriver();
        driverWait = new WebDriverWait(driver, 30);
        javaScriptExecutor = new JavaScriptExecutor(driver, driverWait);
    }
}
