package ylevchenko.gfit.mobile.gui.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.SelectDateModalBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.utils.DateTimeUtils;

import java.time.LocalDateTime;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SelectDateModalBase.class)
public class SetDateModal extends SelectDateModalBase implements IConstants {

    @FindBy(id = "mtrl_picker_header_toggle")
    private ExtendedWebElement changeInputBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/mtrl_picker_text_input_date']//*[@class='android.widget.EditText']")
    private ExtendedWebElement dateInputField;

    @FindBy(id = "confirm_button")
    private ExtendedWebElement okButton;

    public SetDateModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void changeInputMode() {
        changeInputBtn.click();
    }

    @Override
    public AddActivityPageBase selectDate(LocalDateTime date) {
        if (dateInputField.isElementNotPresent(TIMEOUT_SHORTEST)) {
            changeInputMode();
        }
        dateInputField.type(DateTimeUtils.dateFormat(date));
        if (okButton.isElementNotPresent(TIMEOUT_SHORTEST)) {
            getDriver().navigate().back();
        }
        okButton.click();
        return initPage(getDriver(), AddActivityPageBase.class);
    }

}
