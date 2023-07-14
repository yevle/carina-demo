package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;

public abstract class ProfilePageBase extends GsmArenaAbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NewsPageBase loginWithCreds(String login, String pass);

    public abstract boolean isLoggedIn();

    public abstract ForgotPassPageBase clickForgotPass();

}
