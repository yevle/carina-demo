package ylevchenko.tabletki.mobile.gui;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class TabletkiAbstractUIObject extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils, IConstants {

    public TabletkiAbstractUIObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
