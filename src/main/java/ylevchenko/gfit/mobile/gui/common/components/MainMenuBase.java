package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;

import java.util.List;

public abstract class MainMenuBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {

    public MainMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract GFitAbstractPage openMainMenuItem(MainMenuItems item);

    public abstract List<ExtendedWebElement> getMainMenuItems();

}
