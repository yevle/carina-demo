package ylevchenko.carina.mobile.gui.common.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.enums.MainMenuItems;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.service.IConstants;

import java.util.List;

public abstract class MainMenuBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils, IConstants {

    public MainMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isMenuElementPresent(MainMenuItems menuItem);

    public abstract List<String> getMenuItemsText();

    public abstract ExtendedWebElement getMenuItemByIndex(int index);

    public abstract CarinaAbstractPage openMenuItem(MainMenuItems item);

    public abstract CarinaAbstractPage openMenuItemByIndex(int index);

    public abstract List<ExtendedWebElement> getMenuItems();

    public abstract void closeMainMenuBySwipe();

    public abstract void tapOutsideMenuItems(int count);

    public abstract boolean isMainMenuOpened ();

    public abstract void tapOutsideMenu();

}
