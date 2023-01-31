package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.common.BaseLoginPage;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ylevchenko.carina.mobile.gui.common.BaseWelcomePage.class)
public class WelcomePage extends ylevchenko.carina.mobile.gui.common.BaseWelcomePage {

    @FindBy(id = "carina_logo")
    private ExtendedWebElement title;

    @FindBy(id = "next_button")
    private ExtendedWebElement nextBtn;
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseLoginPage clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), BaseLoginPage.class);
    }

    public boolean isPageOpened () {
        return title.isElementPresent();
    }
}
