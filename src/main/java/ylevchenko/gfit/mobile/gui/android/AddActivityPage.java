package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.*;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.enums.AddActivityTextFields;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddActivityPageBase.class)
public class AddActivityPage extends AddActivityPageBase {

    @FindBy(id = "expanded_title")
    private ExtendedWebElement mainTitle;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/text_input_label'][@text='%s']//following-sibling::*/*")
    private ExtendedWebElement activityTextField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/activity_field']/*/*")
    private ExtendedWebElement activityField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/container_action_button'][contains(@text,'{L10N:save}')]")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/time_field']/*[@resource-id='com.google.android.apps.fitness:id/date_button']")
    private ExtendedWebElement dateBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/time_field']/*[@resource-id='com.google.android.apps.fitness:id/time_button']")
    private ExtendedWebElement timeBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/duration_field']/*[@resource-id='com.google.android.apps.fitness:id/time_button']")
    private ExtendedWebElement durationBtn;

    @FindBy(id = "intensity_value")
    private ExtendedWebElement intensityBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/alertTitle']//ancestor::*[@resource-id='com.google.android.apps.fitness:id/parentPanel']")
    private SetActivityTypeModal activityTypeModal;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/mtrl_picker_header']/parent::*")
    private SetDateModal setDateModal;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/header_title'][contains(@text,'{L10N:selectTime}')]/parent::*")
    private SetTimeModal setTimeModal;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/header_title'][contains(@text,'{L10N:selectDuration}')]/parent::*")
    private SetDurationModal setDurationModal;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/alertTitle'][contains(@text,'{L10N:intensity}')]/ancestor::*[@resource-id='com.google.android.apps.fitness:id/parentPanel']")
    private SetIntensityModal setIntensityModal;

    public AddActivityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isElementWithTextPresent(mainTitle, PlusMenuItems.ADD_ACTIVITY.getText());
    }

    @Override
    public SetActivityTypeModal openActivityTypeModal() {
        activityField.click();
        return activityTypeModal;
    }

    @Override
    public AddActivityPageBase inputTextField(AddActivityTextFields field, String text) {
        ExtendedWebElement textField = activityTextField.format(field.getText());
        if (textField.isElementNotPresent(TIMEOUT_SHORTEST)) {
            getDriver().navigate().back();
        }
        textField.type(text);
        return initPage(getDriver(), AddActivityPageBase.class);
    }

    @Override
    public SetDateModal openSetDateModal() {
        dateBtn.click();
        return setDateModal;
    }

    @Override
    public SetTimeModal openSetStartTimeModal() {
        timeBtn.click();
        return setTimeModal;
    }

    @Override
    public SetDurationModal openSetDurationModal() {
        durationBtn.click();
        return setDurationModal;
    }

    @Override
    public SetIntensityModal openSetIntensityModal() {
        intensityBtn.click();
        return setIntensityModal;
    }

    @Override
    public GFitAbstractPage saveChanges(Class<? extends GFitAbstractPage> pageClass) {
        saveBtn.click();
        return initPage(getDriver(), pageClass);
    }

}

