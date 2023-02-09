package ylevchenko.carina.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.common.components.MainMenuBase;

public abstract class MainMenuPageBase extends CarinaAbstractPage {

    public MainMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MainMenuBase openMainMenu();

    public abstract boolean isSliderVisibleAfterSwipe();

}
