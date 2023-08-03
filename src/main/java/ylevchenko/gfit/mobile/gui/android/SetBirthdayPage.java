package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetBirthdayPageBase;

import java.time.LocalDate;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetBirthdayPageBase.class)
public class SetBirthdayPage extends SetBirthdayPageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.gms:id/octarine_webview_container']//*[@text='Birthday']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@text='Update birthday']/following-sibling::*//*[@class='android.widget.Spinner']")
    private ExtendedWebElement monthField;

    @FindBy(xpath = "//*[@text='Update birthday']/following-sibling::*//*[@class='android.widget.Spinner']/parent::*//*[contains(@text,'%s')]")
    private ExtendedWebElement monthByText;

    @FindBy(xpath = "(//*[@text='Update birthday']/following-sibling::*//*[@class='android.widget.Spinner']/parent::*/child::*[2]/*/*)[%s]")
    private ExtendedWebElement monthByIndex;

    @FindBy(xpath = "//*[@text='Update birthday']/following-sibling::*//*[@class='android.widget.Spinner']/parent::*/child::*[2]/*/*")
    private List<ExtendedWebElement> monthList;

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
        return title.isElementPresent(TIMEOUT_SHORT);
    }

    @Override
    public SetBirthdayPageBase setBirthday(LocalDate date) {
        ExtendedWebElement month = monthByIndex.format(String.valueOf(date.getMonthValue()));
        monthField.click();
        if (!month.isVisible(SHORT_TIMEOUT)) {
            Direction direction = (selectedMonthIndex() > date.getMonthValue()) ? Direction.DOWN : Direction.UP;
            swipe(month, monthSpinner, direction, ATTEMPTS_FIVE, SWIPE_DURATION_LONG);
        }
        while (month.getLocation().y < monthField.getLocation().y) {
            int initY = month.getLocation().y;
            swipeInContainer(monthSpinner, Direction.DOWN, ATTEMPTS_ONE, SWIPE_DURATION_LONG);
            if (initY == month.getLocation().y) {
                break;
            }
        }
        month.click();
        if (!dayField.getText().equals(String.valueOf(date.getDayOfMonth()))) {
            dayField.type(String.valueOf(date.getDayOfMonth()));
        }
        if (!yearField.getText().equals(String.valueOf(date.getYear()))) {
            yearField.type(String.valueOf(date.getYear()));
        }
        return initPage(getDriver(), SetBirthdayPageBase.class);
    }

    public int selectedMonthIndex() {
        for (ExtendedWebElement month : monthList) {
            if (Boolean.parseBoolean(month.getAttribute("selected"))) {
                return monthList.indexOf(month);
            }
        }
        return 0;
    }

    @Override
    public ProfilePageBase saveChanges() {
        saveBtn.click(TIMEOUT_SHORTEST);
        if (confirmBtn.isElementPresent(TIMEOUT_SHORTEST)) {
            confirmBtn.click(TIMEOUT_SHORTEST);
        }
        backBtn.click();
        if (isPageOpened()) {
            backBtn.click();
        }
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
