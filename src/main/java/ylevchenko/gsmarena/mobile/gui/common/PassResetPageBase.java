package ylevchenko.gsmarena.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;

public abstract class PassResetPageBase extends GsmArenaAbstractPage {

    public PassResetPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getResultMessage();

    public abstract boolean isPassResetSucceed();

}


