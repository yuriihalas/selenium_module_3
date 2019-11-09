package com.epam.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".my-profile")
    private WebElement profilePicture;

    @FindBy(className = "name")
    private WebElement profileNameText;

    public void clickOnMyProfilePicture() {
        profilePicture.click();
    }

    public String getProfileName() {
        return profileNameText.getText().trim();
    }
}
