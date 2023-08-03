package ylevchenko.gfit.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractUIObject;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.enums.ActivityTypeItems;

public abstract class SetActivityTypeModalBase extends GFitAbstractUIObject {

    public SetActivityTypeModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract AddActivityPageBase setActivityType(ActivityTypeItems activityType);

}
