package ylevchenko.carina.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;

public abstract class WelcomePageBase extends CarinaAbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickNextBtn();

}
