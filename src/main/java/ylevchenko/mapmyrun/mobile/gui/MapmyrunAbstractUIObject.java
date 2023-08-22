package ylevchenko.mapmyrun.mobile.gui;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MapmyrunAbstractUIObject extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils, IConstants {

    public MapmyrunAbstractUIObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
