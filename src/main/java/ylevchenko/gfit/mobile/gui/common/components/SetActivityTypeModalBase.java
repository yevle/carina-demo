package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;

public abstract class ActivityTypeItems extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {

    public ActivityTypeItems(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract AddActivityPageBase chooseActivityType(ActivityTypeItems activityType);

}
