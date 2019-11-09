package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static final String PATH_TO_DRIVER = "src/main/resources/driver/chromedriver.exe";
    private static final String WEB_DRIVER_NAME = "webdriver.chrome.driver";

    private static WebDriver driver;

    static {
        System.setProperty(WEB_DRIVER_NAME, PATH_TO_DRIVER);
    }

    private WebDriverManager() {

    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
