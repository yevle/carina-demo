package ylevchenko.carina.mobile.gui.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.carina.enums.MainMenuItems;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.service.IConstants;

import java.util.List;

public abstract class MainMenuBase extends AbstractUIObject implements ICustomTypePageFactory, IConstants {

    public MainMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isMenuElementPresent(MainMenuItems menuItem);

    public abstract List<String> getMenuItems();

    public abstract ExtendedWebElement getMenuItemByIndex(int index);

    public abstract CarinaAbstractPage openMenuItem(MainMenuItems item);

    public abstract CarinaAbstractPage openMenuItemByIndex(int index);
}
