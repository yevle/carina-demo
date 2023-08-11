package ylevchenko.gsmarena.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.PassResetPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PassResetPageBase.class)
public class PassResetPage extends PassResetPageBase {

    ExtendedWebElement resultText;

    public PassResetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getResultMessage() {
        throw new NotImplementedException();
    }

    public boolean isPassResetSucceed() {
        throw new NotImplementedException();
    }

}
