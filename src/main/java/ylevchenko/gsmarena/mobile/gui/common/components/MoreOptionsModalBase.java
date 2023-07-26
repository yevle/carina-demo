package ylevchenko.gsmarena.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.service.IConstants;

public class MoreOptionsModalBase extends AbstractUIObject implements IMobileUtils, ICustomTypePageFactory, IConstants {

    public MoreOptionsModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
