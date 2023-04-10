package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

import java.util.List;

public abstract class PlusMenuBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {

    public PlusMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract GFitAbstractPage openPlusMenuItem(PlusMenuItems item);

    public abstract void closePlusMenu();

}
