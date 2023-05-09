package ylevchenko.gfit.mobile.gui.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.service.IConstants;

import java.util.List;

public abstract class SettingsPageBase extends GFitAbstractPage implements IConstants {

    public SettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ExtendedWebElement> fillElemList();

    public abstract String getSettingsElemColor(ExtendedWebElement element);

    public abstract SettingsPageBase swipeToSetting(ExtendedWebElement element);

    public abstract ProfilePageBase backToProfilePage();

}
