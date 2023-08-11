package ylevchenko.gfit.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.components.MainMenuBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;

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
    public String getMenuItemColor(MainMenuItems item) {
        return null;
    }

}
