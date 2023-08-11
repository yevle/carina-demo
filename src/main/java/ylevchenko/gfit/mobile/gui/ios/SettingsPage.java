package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ExtendedWebElement> fillElemList() {
        throw new NotImplementedException();
    }

    @Override
    public String getSettingsElemColor(ExtendedWebElement element) {
        throw new NotImplementedException();
    }

    @Override
    public SettingsPageBase swipeToSetting(ExtendedWebElement element) {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase backToProfilePage() {
        throw new NotImplementedException();
    }

}
