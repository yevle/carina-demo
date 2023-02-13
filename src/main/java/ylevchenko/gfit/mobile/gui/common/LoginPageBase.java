package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class LoginPageBase extends GFitAbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AboutYouPageBase login();

}
