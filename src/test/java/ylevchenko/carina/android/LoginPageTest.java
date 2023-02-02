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
import ylevchenko.carina.mobile.gui.service.IConstants;


public class LoginPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @Test(description = "Login page fields, checkboxes and buttons testing")
    @MethodOwner(owner = "ylevchenko")
    public void loginPageCheckTest() {

        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        LoginPageBase loginPage = welcomePage.clickNextBtn();

        softAssert.assertTrue(loginPage.isNameFieldHasText(), "[LOGIN PAGE] - Name field has no text or absent");
        softAssert.assertTrue(loginPage.isPasswordFieldHasText(), "[LOGIN PAGE] - Password field has no text or absent");
        for (Gender gender: Gender.values()) {
            softAssert.assertFalse(loginPage.isGenderFieldChecked(gender), "[LOGIN PAGE] - "+gender.name()+" gender checkbox initially checked while shouldn't be");
            softAssert.assertTrue(loginPage.isGenderFieldHasText(gender), "[LOGIN PAGE] - "+gender.name()+" gender checkbox has no text");
        }
        softAssert.assertFalse(loginPage.isPrivacyPolicyChecked(), "[LOGIN PAGE] - Privacy Policy checkbox initially checked or has no text");
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
        WebViewPageBase webViewPage = loginPage.checkPrivacyPolicyCheckbox(checkbox).clickLoginBtn();

        Assert.assertEquals(webViewPage.isPageOpened(), expectedResult, "Actual result doesn't match expected");
    }

    @DataProvider(name = "login_test_credentials")
    public static Object[][] dataProvider() {
        String loginPass = RandomStringUtils.randomAlphanumeric(LOGIN_SYMBOL_COUNT);
        return new Object[][]{
                {loginPass, loginPass, true, true, true},
                {ONE_SPACE_TEXT, ONE_SPACE_TEXT, true, true, true},
                {EMPTY_TEXT, EMPTY_TEXT, false, false, false},
                {EMPTY_TEXT, EMPTY_TEXT, true, true, false},
                {EMPTY_TEXT, loginPass, true, true, false},
                {loginPass, loginPass, true, false, false}
        };
    }

}
