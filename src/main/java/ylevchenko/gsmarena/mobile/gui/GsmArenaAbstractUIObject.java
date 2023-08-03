package ylevchenko.gsmarena.mobile.gui;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class GsmArenaAbstractUIObject extends AbstractUIObject implements IConstants, IMobileUtils, ICustomTypePageFactory {

    protected GsmArenaAbstractUIObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
