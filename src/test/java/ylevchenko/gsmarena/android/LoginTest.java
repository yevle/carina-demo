package ylevchenko.gsmarena.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.PassResetPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

public class LoginTest implements IMobileUtils, IAbstractTest {

    private String login = "john_tak_@ukr.net";
    private String pass = "john_tak_";

    @Test(description = "Login to profile using credentials")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void LoginTest() {

        NewsPageBase newsPage = initPage(getDriver(), NewsPageBase.class);
        Assert.assertTrue(newsPage.isPageOpened());

        ProfilePageBase profilePage = (ProfilePageBase)newsPage.openLeftMenuItem(LeftMenuItems.PROFILE);
        profilePage = (ProfilePageBase)profilePage.loginWithCreds(login, pass).openLeftMenuItem(LeftMenuItems.PROFILE);
        Assert.assertTrue(profilePage.isLoggedIn());

    }

    @Test(description = "Checking if forgot pass function works correct")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void ForgotPassTest() {

        NewsPageBase newsPage = initPage(getDriver(), NewsPageBase.class);
        Assert.assertTrue(newsPage.isPageOpened(), "[NEWS PAGE] - Main page didn't open");

        ProfilePageBase profilePage = (ProfilePageBase)newsPage.openLeftMenuItem(LeftMenuItems.PROFILE);
        PassResetPageBase passResetPage = profilePage.clickForgotPass().submitPassReset(login);

        Assert.assertTrue(passResetPage.isPassResetSucceed(), "[PassResetPage] - Password reset has failed.");

    }


}
