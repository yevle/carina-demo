package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.components.SelectTimeModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.utils.DateTimeFormat;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SelectTimeModalBase.class)
public class SelectTimeModal extends SelectTimeModalBase implements IConstants {

    @FindBy(id="material_timepicker_mode_button")
    private ExtendedWebElement changeInputBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/material_hour_text_input']/*/*/*")
    private ExtendedWebElement hourInputField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/material_minute_text_input']//*[@content-desc]")
    private ExtendedWebElement minuteChooseField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/material_minute_text_input']//*[@class='android.widget.EditText']")
    private ExtendedWebElement minuteInputField;

    @FindBy(id = "material_timepicker_ok_button")
    private ExtendedWebElement okButton;

    public SelectTimeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void changeInputMode() {
        changeInputBtn.click();
    }

    @Override
    public void selectTime(LocalDateTime date) {
        if (hourInputField.isElementNotPresent(TIMEOUT_SHORT)) changeInputMode();
        hourInputField.type(DateTimeFormat.getHour(date));
        minuteChooseField.click();
        minuteInputField.type(String.valueOf(date.getMinute()));
        okButton.click();
    }

}
