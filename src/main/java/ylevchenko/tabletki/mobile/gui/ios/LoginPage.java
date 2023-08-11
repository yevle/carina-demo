package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.LoginPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProfilePageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    ExtendedWebElement emailTextField;

    ExtendedWebElement passTextField;

    ExtendedWebElement loginBtn;

    ExtendedWebElement googleSignSuggest;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePageBase loginWithCreds(String email, String pass) {
        throw new NotImplementedException();
    }

}
