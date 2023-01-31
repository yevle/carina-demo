package ylevchenko.carina.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.carina.CarinaAbstractPage;

public abstract class BaseWelcomePage extends CarinaAbstractPage {

    public BaseWelcomePage(WebDriver driver) {
        super(driver);
    }
    public abstract BaseLoginPage clickNextBtn();
}
