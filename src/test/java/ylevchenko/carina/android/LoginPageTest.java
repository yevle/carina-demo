package ylevchenko.carina.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.carina.enums.Gender;
import ylevchenko.carina.mobile.gui.common.LoginPageBase;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import ylevchenko.carina.mobile.gui.common.WelcomePageBase;


public class LoginPageTest implements IAbstractTest, IMobileUtils {

    @Test(description = "Login page fields, checkboxes and buttons testing")
    @MethodOwner(owner = "ylevchenko")
    public void loginPageCheckTest() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        LoginPageBase loginPage = welcomePage.clickNextBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isNameFieldHasText(), "[LOGIN PAGE] - Name field has no text or absent");
        softAssert.assertTrue(loginPage.isPasswordFieldHasText(), "[LOGIN PAGE] - Password field has no text or absent");
        softAssert.assertTrue(loginPage.isGenderFieldHasTextAndUnchecked(Gender.MALE), "[LOGIN PAGE] - Male gender checkbox initially checked or has no text");
        softAssert.assertTrue(loginPage.isGenderFieldHasTextAndUnchecked(Gender.FEMALE), "[LOGIN PAGE] - Female gender checkbox initially checked or has no text");
        softAssert.assertTrue(loginPage.isPrivacyPolicyHasTextAndUnchecked(), "[LOGIN PAGE] - Privacy Policy checkbox initially checked or has no text");
        softAssert.assertFalse(loginPage.isLoginBtnActive(), "[LOGIN PAGE] - Login button is active while initially shouldn't");
        softAssert.assertAll();
    }

    @Test(description = "Different login scenarios testing", dataProvider = "login_test_credentials")
    @MethodOwner(owner = "ylevchenko")
    public void loginTest(String uname, String pass, Boolean gender, Boolean checkbox, Boolean expectedResult) {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "[LOGIN PAGE] - Login button is active in spite of empty fields!");

        loginPage.typeName(uname).typePassword(pass);
        if (gender) {
            loginPage.selectGender(Gender.MALE);
        }
        if (checkbox) {
            loginPage.checkPrivacyPolicyCheckbox();
        }
        WebViewPageBase webViewPage = loginPage.clickLoginBtn();

        Assert.assertEquals(webViewPage.isPageOpened(), expectedResult, "Actual result doesn't match expected");
    }

    @DataProvider(name = "login_test_credentials")
    public static Object[][] dataProvider() {
        String loginPass = RandomStringUtils.randomAlphanumeric(7);
        return new Object[][]{
                {loginPass, loginPass, true, true, true},
                {" ", " ", true, true, true},
                {"", "", false, false, false},
                {"", "", true, true, false},
                {"", loginPass, true, true, false},
                {loginPass, loginPass, true, false, false}
        };
    }

}
