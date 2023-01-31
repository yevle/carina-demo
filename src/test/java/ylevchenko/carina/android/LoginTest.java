package ylevchenko.carina.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ylevchenko.carina.enums.Gender;
import ylevchenko.carina.mobile.gui.android.WelcomePage;
import ylevchenko.carina.mobile.gui.common.BaseCarinaWebViewPage;
import ylevchenko.carina.mobile.gui.common.BaseLoginPage;
import ylevchenko.carina.mobile.gui.common.BaseWelcomePage;


public class LoginTest implements IAbstractTest, IMobileUtils {
    @Test(description = "Positive login scenario testing", dataProvider = "positive_login_credentials")
    @MethodOwner(owner = "ylevchenko")
    public void testPositiveLoginUser(String username, String password, Gender gender) {
        BaseWelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        BaseLoginPage loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active in spite of empty fields!");

        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.selectGender(gender.getName());
        loginPage.checkPrivacyPolicyCheckbox();
        BaseCarinaWebViewPage webViewPage = loginPage.clickLoginBtn();

        Assert.assertTrue(webViewPage.isPageOpened(), "Carina web view page isn't opened");
    }

    @Test(description = "Negative login scenarios testing", dataProvider = "negative_login_credentials")
    @MethodOwner(owner = "ylevchenko")
    public void negativeLoginTest(String uname, String pass, Gender gender, boolean privacy) {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        BaseLoginPage loginPage = welcomePage.clickNextBtn();

        loginPage.typeName(uname);
        loginPage.typePassword(pass);
        if (!gender.equals(Gender.UNCHECKED)) loginPage.selectGender(gender.getName());
        if (privacy) loginPage.checkPrivacyPolicyCheckbox();

        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active!");
    }

    @DataProvider(name = "negative_login_credentials")
    public static Object[][] negativeData() {
        return new Object[][]{
                {"", "", Gender.UNCHECKED, false},
                {"", "", Gender.MALE, true},
                {"", "pass", Gender.MALE, true},
                {"login", "pass", Gender.FEMALE, false},
                {"login", "pass", Gender.UNCHECKED, true}
        };
    }

    @DataProvider(name = "positive_login_credentials")
    public static Object[][] positiveData() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), Gender.MALE},
                {" ", " ", Gender.FEMALE},
        };
    }
}
