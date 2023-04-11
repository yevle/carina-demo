package ylevchenko.gfit.mobile.gui.ios.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.components.MainMenuBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase {

    public MainMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GFitAbstractPage openMainMenuItem(MainMenuItems item) {
        throw new NotImplementedException();
    }

    @Override
    public List<ExtendedWebElement> getMainMenuItems() {
        throw new NotImplementedException();
    }


}
