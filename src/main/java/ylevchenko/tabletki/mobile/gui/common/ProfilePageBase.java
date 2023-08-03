package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

public abstract class ProfilePageBase extends TabletkiAbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase openLoginPage();

    public abstract TabletkiAbstractPage openMenuItem(MainMenuItems items);

}
