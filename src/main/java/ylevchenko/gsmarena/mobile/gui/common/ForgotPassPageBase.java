package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;

public abstract class ForgotPassPageBase extends GsmArenaAbstractPage {

    public ForgotPassPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PassResetPageBase submitPassReset(String email);

}
