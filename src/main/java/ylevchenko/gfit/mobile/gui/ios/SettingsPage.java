package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

}
