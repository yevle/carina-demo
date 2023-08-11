package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.android.components.MainMenuModal;
import ylevchenko.tabletki.mobile.gui.common.LoginPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProfilePageBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    ExtendedWebElement loginBtn;

    MainMenuModal mainMenu;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public LoginPageBase openLoginPage () {
        throw new NotImplementedException();
    }

    public TabletkiAbstractPage openMenuItem(MainMenuItems items) {
        throw new NotImplementedException();
    }

}
