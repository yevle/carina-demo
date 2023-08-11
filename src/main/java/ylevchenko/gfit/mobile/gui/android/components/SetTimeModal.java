package ylevchenko.gfit.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SetTimeModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.utils.DateTimeUtils;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetTimeModalBase.class)
public class SetTimeModal extends SetTimeModalBase implements IConstants {

    @FindBy(id = "material_timepicker_mode_button")
    private ExtendedWebElement changeInputBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/material_hour_text_input']/*/*/*")
    private ExtendedWebElement hourInputField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/material_minute_text_input']//*[@content-desc]")
    private ExtendedWebElement minuteChooseField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/material_minute_text_input']//*[@class='android.widget.EditText']")
    private ExtendedWebElement minuteInputField;

    @FindBy(id = "material_timepicker_ok_button")
    private ExtendedWebElement okButton;

    public SetTimeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void changeInputMode() {
        changeInputBtn.click();
    }

    @Override
    public AddActivityPageBase selectTime(LocalDateTime date) {
        if (hourInputField.isElementNotPresent(TIMEOUT_SHORTEST)) changeInputMode();
        hourInputField.type(DateTimeUtils.getHour(date));
        minuteChooseField.click();
        minuteInputField.type(String.valueOf(date.getMinute()));
        okButton.click();
        return initPage(getDriver(), AddActivityPageBase.class);
    }

}
