package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;
import ylevchenko.gfit.mobile.gui.enums.AboutYouItems;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public SettingsPageBase openSettings() {
        throw new NotImplementedException();
    }

    @Override
    public GFitAbstractPage editAboutYouField(AboutYouItems field) {
        throw new NotImplementedException();
    }

    @Override
    public String getAboutYouFieldText(AboutYouItems field) {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase sleepSwitchChecker(Boolean toCheck) {
        throw new NotImplementedException();
    }

    @Override
    public String getSleepSwitchColor() {
        throw new NotImplementedException();
    }

    @Override
    public String getAccLogoColor() {
        throw new NotImplementedException();
    }

    @Override
    public MainMenu getMainMenu() {
        throw new NotImplementedException();
    }

}
