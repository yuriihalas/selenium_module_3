package com.epam.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {

    @FindBy(id = "email")
    private WebElement fieldEmail;

    @FindBy(css = "*[type='password']")
    private WebElement fieldPassword;

    @FindBy(id = "submit-button")
    private WebElement buttonLoginIntoAccount;

    public void fillEmailField(String email) {
        fieldEmail.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickOnLoginIntoAccount() {
        buttonLoginIntoAccount.click();
    }
}
