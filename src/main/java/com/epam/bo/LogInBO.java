package com.epam.bo;

import com.epam.model.User;
import com.epam.po.AuthorizationPage;
import com.epam.po.HomePage;
import com.epam.po.WelcomePage;

public class LogInBO {
    private WelcomePage welcomePage;
    private AuthorizationPage authorizationPage;
    private HomePage homePage;

    public LogInBO() {
        welcomePage = new WelcomePage();
        authorizationPage = new AuthorizationPage();
        homePage = new HomePage();
    }

    public void login(User user) {
        welcomePage.clickOnLoginButton();
        authorizationPage.fillEmailField(user.getEmail());
        authorizationPage.fillPasswordField(user.getPassword());
        authorizationPage.clickOnLoginIntoAccount();
    }
}
