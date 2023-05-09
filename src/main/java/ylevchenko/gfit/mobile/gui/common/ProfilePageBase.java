package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.enums.AboutYouItems;

public abstract class ProfilePageBase extends GFitAbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SettingsPageBase openSettings();

    public abstract GFitAbstractPage editAboutYouField(AboutYouItems field);

    public abstract String getAboutYouFieldText(AboutYouItems field);

    public abstract ProfilePageBase sleepSwitchChecker(Boolean toCheck);

    public abstract String getSleepSwitchColor();

    public abstract String getAccLogoColor();

    public abstract MainMenu getMainMenu();

}
