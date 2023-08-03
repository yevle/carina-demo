package ylevchenko.gsmarena.mobile.gui.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.ForgotPassPageBase;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    ExtendedWebElement emailInputField;

    ExtendedWebElement passInputField;

    ExtendedWebElement loginBtn;

    ExtendedWebElement logoutBtn;

    ExtendedWebElement manageAccountBtn;

    ExtendedWebElement forgotPassLink;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewsPageBase loginWithCreds(String login, String pass) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLoggedIn() {
        throw new NotImplementedException();
    }

    @Override
    public ForgotPassPageBase clickForgotPass() {
        throw new NotImplementedException();
    }

    @Override
    public boolean checkFavoritesContains(String keyword) {
        throw new NotImplementedException();
    }

    @Override
    public void cleanFavorites() {
        throw new NotImplementedException();
    }

}
