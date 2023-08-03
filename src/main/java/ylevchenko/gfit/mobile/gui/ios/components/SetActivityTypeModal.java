package ylevchenko.gfit.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SetActivityTypeModalBase;
import ylevchenko.gfit.mobile.gui.enums.ActivityTypeItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SetActivityTypeModalBase.class)
public class SetActivityTypeModal extends SetActivityTypeModalBase {

    public SetActivityTypeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AddActivityPageBase setActivityType(ActivityTypeItems activityType) {
        throw new NotImplementedException();
    }

}
