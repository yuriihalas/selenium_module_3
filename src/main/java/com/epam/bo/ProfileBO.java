package com.epam.bo;

import com.epam.model.ProfileInfo;
import com.epam.model.User;
import com.epam.po.HomePage;
import com.epam.po.ProfilePage;
import org.testng.Assert;

public class ProfileBO {
    private HomePage homePage;
    private ProfilePage profilePage;

    public ProfileBO() {
        homePage = new HomePage();
        profilePage = new ProfilePage();
    }

    public void goToProfileAndEditUserInformation(ProfileInfo profileInfo) {
        profilePage.clickOnEditProfile();
        profilePage.setNewProfileTitle(profileInfo.getTitle());
        profilePage.setNewProfileLocation(profileInfo.getLocation());
        profilePage.setNewAboutMeInfo(profileInfo.getAboutMe());
        profilePage.clickOnButtonSaveChanges();
    }

    public void verifyProfileInfo(ProfileInfo profileInfo) {
        profilePage.clickOnProfile();
        ProfileInfo actualProfileInfo = new ProfileInfo();
        actualProfileInfo.setTitle(profilePage.getTitle());
        actualProfileInfo.setLocation(profilePage.getLocation());
        actualProfileInfo.setAboutMe(profilePage.getProfileUserBio());
        Assert.assertEquals(actualProfileInfo, profileInfo);
    }

    public void verifySuccessfullyLogin(User user) {
        homePage.clickOnMyProfilePicture();
        String actualUsername = homePage.getProfileName();
        Assert.assertEquals(actualUsername, user.getNickname());
    }
}
