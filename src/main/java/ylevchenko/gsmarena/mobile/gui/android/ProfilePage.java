package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.ForgotPassPageBase;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(id = "input_email")
    ExtendedWebElement emailInputField;

    @FindBy(id = "input_password")
    ExtendedWebElement passInputField;

    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/btn_login'][@text, 'LOGIN']")
    ExtendedWebElement loginBtn;

    @FindBy (xpath = "//*[@content-desc='LOGOUT']")
    ExtendedWebElement logoutBtn;

    @FindBy (xpath = "//*[@content-desc='MANAGE ACCOUNT']")
    ExtendedWebElement manageAccountBtn;

    @FindBy (id = "link_forgot_password")
    ExtendedWebElement forgotPassLink;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public NewsPageBase loginWithCreds(String login, String pass) {
        emailInputField.type(login);
        passInputField.type(pass);
        loginBtn.click();
        return initPage(getDriver(), NewsPageBase.class);
    }

    public boolean isLoggedIn() {
        return logoutBtn.isElementPresent(TIMEOUT_SHORTEST)&&manageAccountBtn.isElementPresent(TIMEOUT_SHORTEST);
    }

    public ForgotPassPageBase clickForgotPass() {
        forgotPassLink.click();
        return initPage(getDriver(), ForgotPassPageBase.class);
    }

}
