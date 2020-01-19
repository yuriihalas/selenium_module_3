package com.epam;

import com.epam.bo.LogInBO;
import com.epam.bo.ProfileBO;
import com.epam.model.ProfileInfo;
import com.epam.model.User;
import com.epam.utils.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.utils.PropertyParser.getPropertyOrDefault;

public class StackOverflowTest {
    private static final String BASE_PAGE_STACK_OVERFLOW = "https://stackoverflow.com";

    @DataProvider
    public static Object[][] userCredentials() {
        return new Object[][]{{
                new User(getPropertyOrDefault("nick"), getPropertyOrDefault("email"), getPropertyOrDefault("pass")),
                new ProfileInfo(getPropertyOrDefault("title"), getPropertyOrDefault("location"), getPropertyOrDefault("about"))
        }};
    }

    @BeforeTest
    public void initBasePage() {
        WebDriverManager.getDriver().get(BASE_PAGE_STACK_OVERFLOW);
    }

    @AfterTest
    public void quitWebDriver() {
        WebDriverManager.quit();
    }

    @Test(dataProvider = "userCredentials")
    public void testLoginAndEditingProfileInfo(User user, ProfileInfo profileInfo) {
        LogInBO logInBO = new LogInBO();
        logInBO.login(user);
        ProfileBO profileBO = new ProfileBO();
        profileBO.verifySuccessfullyLogin(user);
        profileBO.goToProfileAndEditUserInformation(profileInfo);
        profileBO.verifyProfileInfo(profileInfo);
    }
}
