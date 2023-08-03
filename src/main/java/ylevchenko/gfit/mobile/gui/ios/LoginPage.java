package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AboutYouPageBase;
import ylevchenko.gfit.mobile.gui.common.LoginPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    public AboutYouPageBase login() {
        throw new NotImplementedException();
    }

}
