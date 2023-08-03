package ylevchenko.gsmarena.mobile.gui.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.ForgotPassPageBase;
import ylevchenko.gsmarena.mobile.gui.common.PassResetPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ForgotPassPageBase.class)
public class ForgotPassPage extends ForgotPassPageBase {

    ExtendedWebElement emailTextField;

    ExtendedWebElement submitBtn;

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PassResetPageBase submitPassReset(String email) {
        throw new NotImplementedException();
    }

}
