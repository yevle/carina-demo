package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;

public abstract class LoginPageBase extends TabletkiAbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProfilePageBase loginWithCreds(String email, String pass);

}
