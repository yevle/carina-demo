package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class SetModalBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {

    public SetModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract int setIntensity();

}
