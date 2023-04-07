package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.*;
import ylevchenko.gfit.mobile.gui.common.ActivityEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.enums.AddActivityTextFields;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ActivityEntityPage.class)
public class ActivityEntityPage extends ActivityEntityPageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/sessions_title_view']//*[@resource-id='com.google.android.apps.fitness:id/title']")
    private ExtendedWebElement mainTitle;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/sessions_title_view']//*[@resource-id='com.google.android.apps.fitness:id/subtitle']")
    private ExtendedWebElement dateTimeField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/session_coaching_metrics']//*[@resource-id='com.google.android.apps.fitness:id/heart_points_view']")
    private ExtendedWebElement heartPoints;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/session_coaching_metrics']//*[@resource-id='com.google.android.apps.fitness:id/steps_view']")
    private ExtendedWebElement stepsField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/active_time']//*[@content-desc]")
    private ExtendedWebElement durationField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/distance']//*[@content-desc]")
    private ExtendedWebElement distanceField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/energy']//*[@content-desc]")
    private ExtendedWebElement energyField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/active_minutes']//*[@content-desc]")
    private ExtendedWebElement activeMinutesField;

    public ActivityEntityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isElementWithTextPresent(mainTitle, PlusMenuItems.ADD_ACTIVITY.getText());
    }


}

