package ylevchenko.tabletki.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractUIObject;
import ylevchenko.tabletki.mobile.gui.common.components.MainMenuModalBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainMenuModalBase.class)
public class MainMenuModal extends TabletkiAbstractUIObject {

    ExtendedWebElement menuItem;

    public MainMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public TabletkiAbstractPage openMenuItem(MainMenuItems item) {
        throw new NotImplementedException();
    }

}
