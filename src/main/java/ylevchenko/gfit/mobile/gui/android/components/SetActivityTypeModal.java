package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SetActivityTypeModalBase;
import ylevchenko.gfit.mobile.gui.enums.ActivityTypeItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetActivityTypeModalBase.class)
public class SetActivityTypeModal extends SetActivityTypeModalBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/select_dialog_listview']/*[contains(@text, '%s')]")
    private ExtendedWebElement activityField;

    public SetActivityTypeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AddActivityPageBase setActivityType(ActivityTypeItems activityType) {
        activityField.format(activityType.getText()).click();
        return initPage(getDriver(), AddActivityPageBase.class);
    }

}
