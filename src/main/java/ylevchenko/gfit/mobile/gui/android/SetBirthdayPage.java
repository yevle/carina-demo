package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetBirthdayPageBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetBirthdayPageBase.class)
public class SetBirthdayPage extends SetBirthdayPageBase {


    @FindBy(xpath = "//*[@resource-id='com.google.android.gms:id/octarine_webview_container']//*[@text='Birthday']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@class='android.widget.Spinner'][contains(@text,'Month')]")
    private ExtendedWebElement monthField;

    @FindBy(xpath = "//*[@class='android.widget.Spinner'][contains(@text,'Month')]/parent::*//*[contains(@text,'%s')]")
    private ExtendedWebElement monthByText;

    @FindBy(xpath = "(//*[@class='android.widget.Spinner'][contains(@text,'Month')]/parent::*/child::*[2]/*/*)[%s]")
    private ExtendedWebElement monthByIndex;

    @FindBy(xpath = "//*[@class='android.widget.Spinner']/following-sibling::*")
    private ExtendedWebElement monthSpinner;

    @FindBy(xpath = "//*[contains(@text,'Day')]/following-sibling::*[@class='android.widget.EditText']")
    private ExtendedWebElement dayField;

    @FindBy(xpath = "//*[contains(@text,'Year')]/following-sibling::*[@class='android.widget.EditText']")
    private ExtendedWebElement yearField;

    @FindBy(xpath = "//*[@class='android.widget.Button'][contains(@text,'Save')]")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//*[@class='android.app.Dialog'][contains(@text,'Confirm')]//*[@text='Confirm']")
    private ExtendedWebElement confirmBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backBtn;

    @FindBy(xpath = "//*[@class='android.widget.RadioButton'][@text='%s']")
    private ExtendedWebElement genderRadioBtn;

    public SetBirthdayPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public SetBirthdayPageBase setBirthday(LocalDate date) {
        LocalDate presetDate = LocalDate.parse(monthField.getText().replace("Month ", "") + " " + dayField.getText() +
                " " + yearField.getText(), DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH));
        if (!monthField.getText().contains(date.format(TEXT_MONTH))) {
            monthField.click();
            if (monthByIndex.format(String.valueOf(date.getMonthValue())).isElementNotPresent(SHORT_TIMEOUT)) {
                Direction direction = Direction.UP;
                if (presetDate.getMonthValue() > date.getMonthValue()) {
                    direction = Direction.DOWN;
                }
                swipe(monthByIndex.format(String.valueOf(date.getMonthValue())), monthSpinner, direction, ATTEMPTS_FIVE, SWIPE_DURATION_LONG);

            }
            monthByIndex.format(String.valueOf(date.getMonthValue())).click();
        }
        if (!dayField.getText().equals(String.valueOf(date.getDayOfMonth()))) {
            dayField.type(String.valueOf(date.getDayOfMonth()));
        }
        if (!yearField.getText().equals(String.valueOf(date.getYear()))) {
            yearField.type(String.valueOf(date.getYear()));
        }
        return initPage(getDriver(), SetBirthdayPageBase.class);
    }

    @Override
    public ProfilePageBase saveChanges() {
        saveBtn.click(TIMEOUT_SHORT);
        if (confirmBtn.isElementPresent(TIMEOUT_SHORT)) {
            confirmBtn.click(TIMEOUT_SHORT);
        }
        backBtn.click(TIMEOUT_SHORT);
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
