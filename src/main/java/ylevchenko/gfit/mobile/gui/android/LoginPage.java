package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.AboutYouPageBase;
import ylevchenko.gfit.mobile.gui.common.LoginPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "fit_app_icon")
    private ExtendedWebElement appIcon;

    @FindBy(id = "main_headline")
    private ExtendedWebElement headline;

    @FindBy(id = "sign_in_button")
    private ExtendedWebElement signInBtn;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return appIcon.isElementPresent(TIMEOUT_SHORTEST) && headline.isElementPresent(TIMEOUT_SHORTEST);
    }

    public AboutYouPageBase login() {
        loginInBtn.click();
        return initPage(getDriver(), AboutYouPageBase.class);
    }

}
