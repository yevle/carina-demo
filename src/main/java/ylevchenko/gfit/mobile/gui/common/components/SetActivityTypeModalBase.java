package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.enums.ActivityTypeItems;
import ylevchenko.gfit.mobile.gui.service.IConstants;

public abstract class SetActivityTypeModalBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils, IConstants {

    public SetActivityTypeModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract AddActivityPageBase setActivityType(ActivityTypeItems activityType);

}
