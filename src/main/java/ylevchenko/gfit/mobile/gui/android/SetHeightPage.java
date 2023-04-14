package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetHeightPageBase;
import ylevchenko.gfit.mobile.gui.utils.ExtractorUtils;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetHeightPageBase.class)
public class SetHeightPage extends SetHeightPageBase {

    @FindBy(id = "alertTitle")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@resource-id='android:id/text1'][@class='android.widget.TextView']")
    private ExtendedWebElement unitsSpinnerText;

    @FindBy(xpath = "//*[@resource-id='android:id/text1'][@text='%s']")
    private ExtendedWebElement spinnerItem;

    @FindBy(xpath = "//*[@resource-id='android:id/button1'][@text='OK']")
    private ExtendedWebElement okBtn;

    @FindBy(xpath = "(//*[@class='android.widget.NumberPicker'])[%s]")
    private ExtendedWebElement numberPicker;

    @FindBy(xpath = "(//*[@resource-id='android:id/numberpicker_input'][@class='android.widget.EditText'])[%s]")
    private ExtendedWebElement unitValue;

    @FindBy(xpath = "(//*[@resource-id='android:id/numberpicker_input'][contains(@text,'%s')])")
    private ExtendedWebElement selectValue;

    public SetHeightPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementWithTextPresent("Height");
    }


    @Override
    public SetHeightPageBase setUnits(String units) {
        unitsSpinnerText.click();
        spinnerItem.format(units).click();

        return initPage(getDriver(), SetHeightPageBase.class);
    }

    @Override
    public SetHeightPageBase setHeight(int height) {
        if (!unitsSpinnerText.getText().equals(UNITS.get("CM"))) {
            setUnits(UNITS.get("CM"));
        }
        int presetHeight = ExtractorUtils.extractIntValue(unitValue.format("1").getText());
        Direction direction = Direction.UP;
        if (presetHeight > height) {
            direction = Direction.DOWN;
        }
        swipe(selectValue.format(String.valueOf(height)), numberPicker.format("1"), direction, ATTEMPTS_FIFTY, SWIPE_DURATION_LONG);

        return initPage(getDriver(), SetHeightPageBase.class);
    }

    @Override
    public int getHeight() {
        if (!unitsSpinnerText.getText().equals(UNITS.get("CM"))) {
            setUnits(UNITS.get("CM"));
        }
        return ExtractorUtils.extractIntValue(unitValue.format("1").getText());
    }

    @Override
    public String getHeightFt() {
        if (!unitsSpinnerText.getText().equals(UNITS.get("FT"))) {
            setUnits(UNITS.get("FT"));
        }
        String ftValue = unitValue.format("1").getText().replace(FEET_TEXT, FEET_MARK);
        String inValue = unitValue.format("2").getText().replace(INCH_TEXT, INCH_MARK);

        return ftValue + inValue;
    }

    @Override
    public ProfilePageBase saveChanges() {
        okBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
