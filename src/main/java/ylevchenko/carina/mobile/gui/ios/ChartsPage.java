package ylevchenko.carina.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.android.components.MainMenu;
import ylevchenko.carina.mobile.gui.common.ChartsPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    private ExtendedWebElement title;

    private ExtendedWebElement mainMenuBtn;

    private MainMenu mainMenuModal;

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenu tapMainMenuButton() {
        mainMenuBtn.click();
        return mainMenuModal;
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORT);
    }

}
