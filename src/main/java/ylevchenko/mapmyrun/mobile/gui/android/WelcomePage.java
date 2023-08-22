package ylevchenko.mapmyrun.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.mapmyrun.mobile.gui.common.SignUpPageBase;
import ylevchenko.mapmyrun.mobile.gui.common.WelcomePageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/joinButton']")
    ExtendedWebElement joinNowBtn;

    ExtendedWebElement logInBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public SignUpPageBase signUp() {
        joinNowBtn.click();
        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return joinNowBtn.isElementPresent(TIMEOUT_SHORTEST);
    }
}
