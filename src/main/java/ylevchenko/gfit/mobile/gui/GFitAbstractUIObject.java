package ylevchenko.gfit.mobile.gui;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.service.IConstants;

public abstract class GFitAbstractUIObject extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils, IConstants {

    protected GFitAbstractUIObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
