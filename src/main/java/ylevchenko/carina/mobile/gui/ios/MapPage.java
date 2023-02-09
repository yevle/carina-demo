package ylevchenko.carina.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.mobile.gui.android.components.MainMenu;
import ylevchenko.carina.mobile.gui.common.MapPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    private ExtendedWebElement title;

    private ExtendedWebElement mainMenuBtn;

    private MainMenu mainMenuModal;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenu openMainMenu() {
        mainMenuBtn.click();
        return mainMenuModal;
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORT);
    }

    @Override
    public boolean isSliderVisibleAfterSwipe() {
        throw new NotImplementedException();
    }

}
