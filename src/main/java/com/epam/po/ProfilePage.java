package com.epam.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePage {

    @FindBy(css = "a[href*='users/edit']")
    private WebElement buttonEditProfile;

    @FindBy(css = "input[name='Location'")
    private WebElement fieldLocation;

    @FindBy(xpath = "//input[@name='Title']")
    private WebElement fieldTitle;

    @FindBy(xpath = "//textarea[@name='AboutMe']")
    private WebElement fieldAboutMe;

    @FindBy(xpath = "//input[@value='Save Profile']")
    private WebElement buttonSaveChanges;

    @FindBy(xpath = "//*[@class='vote-accepted-on' and @title='success']")
    private WebElement textSuccessSavedChanges;

    @FindBy(css = "#tabs > *[href$='tab=profile'][data-shortcut='P']")
    private WebElement profileTab;

    @FindBy(className = "profile-user--role")
    private WebElement profileTitle;

    @FindBy(xpath = "//div[@id='user-card']//li[@class='grid--cell ow-break-word']")
    private WebElement profileLocation;

    @FindBy(className = "profile-user--bio")
    private WebElement profileBio;

    public void clickOnEditProfile() {
        buttonEditProfile.click();
    }

    public void setNewProfileLocation(String location) {
        fieldLocation.clear();
        fieldLocation.sendKeys(location);
    }

    public void setNewProfileTitle(String title) {
        fieldTitle.clear();
        fieldTitle.sendKeys(title);
    }

    public void setNewAboutMeInfo(String aboutMe) {
        fieldAboutMe.clear();
        fieldAboutMe.sendKeys(aboutMe);
    }

    public void clickOnButtonSaveChanges() {
        javaScriptExecutor.waitForJQueryLoad();
        driverWait.pollingEvery(1, TimeUnit.SECONDS).until((ExpectedCondition<Object>) webDriver -> {
            buttonSaveChanges.click();
            return textSuccessSavedChanges.isDisplayed();
        });
    }

    public void clickOnProfile() {
        javaScriptExecutor.scrollIntoElement(profileTab);
        profileTab.click();
    }

    public String getTitle() {
        return profileTitle.getText();
    }

    public String getLocation() {
        return profileLocation.getText();
    }

    public String getProfileUserBio() {
        return profileBio.getText();
    }
}