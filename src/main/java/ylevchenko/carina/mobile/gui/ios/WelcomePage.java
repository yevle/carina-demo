package ylevchenko.carina.mobile.gui.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.common.LoginPageBase;
import ylevchenko.carina.mobile.gui.common.WelcomePageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to Carina World!']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
    private ExtendedWebElement nextBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    public boolean isPageOpened() {
        return pageTitle.isElementPresent(TIMEOUT_SHORT);
    }

}
