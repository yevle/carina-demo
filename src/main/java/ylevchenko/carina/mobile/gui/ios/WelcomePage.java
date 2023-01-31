package ylevchenko.carina.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.common.BaseLoginPage;
import ylevchenko.carina.mobile.gui.common.BaseWelcomePage;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BaseWelcomePage.class)
public class WelcomePage extends BaseWelcomePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseLoginPage clickNextBtn() {
        throw new NotImplementedException();
    }

    public boolean isPageOpened () {
        throw new NotImplementedException();
    }
}
