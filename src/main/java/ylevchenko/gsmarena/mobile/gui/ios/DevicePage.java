package ylevchenko.gsmarena.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DevicePageBase.class)
public class DevicePage extends DevicePageBase {

    private ExtendedWebElement favouriteBtn;
    private ExtendedWebElement fanText;
    private ExtendedWebElement title;

    public DevicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DevicePageBase addToFavourites() {
        throw new NotImplementedException();
    }

    public DevicePageBase removeFromFavourites() {
        throw new NotImplementedException();
    }

    public String getTitle() {
        throw new NotImplementedException();
    }

    public SearchPageBase goBackToSearch() {
        throw new NotImplementedException();
    }

    public ProfilePageBase goBackToProfile() {
        throw new NotImplementedException();
    }

}
