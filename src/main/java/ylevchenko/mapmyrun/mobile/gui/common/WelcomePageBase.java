package ylevchenko.mapmyrun.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.mapmyrun.mobile.gui.MapmyrunAbstractPage;

public abstract class WelcomePageBase extends MapmyrunAbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignUpPageBase signUp();

}
