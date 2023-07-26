package ylevchenko.gsmarena.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LeftMenuModalBase extends AbstractUIObject  implements IMobileUtils, ICustomTypePageFactory {

    public LeftMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
