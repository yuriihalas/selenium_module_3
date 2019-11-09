package com.epam.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "//*[@data-gps-track='login.click']")
    private WebElement buttonLogin;

    public void clickOnLoginButton() {
        buttonLogin.click();
    }
}
