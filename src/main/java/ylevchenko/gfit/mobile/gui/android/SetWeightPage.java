package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetWeightPageBase;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetWeightPageBase.class)
public class SetWeightPage extends SetWeightPageBase {

    @FindBy(id = "alertTitle")
    private ExtendedWebElement title;

    @FindBy(id = "unit_spinner")
    private ExtendedWebElement unitsSpinner;

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

    @FindBy(xpath = "(//*[@resource-id='android:id/numberpicker_input'][@text='%s'])[%s]")
    private ExtendedWebElement selectValue;

    public SetWeightPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementWithTextPresent("Weight");
    }

    @Override
    public SetWeightPageBase setUnits(String units) {
        unitsSpinner.click();
        spinnerItem.format(units).click();
        return initPage(getDriver(), SetWeightPageBase.class);
    }

    @Override
    public SetWeightPageBase setWeight(double weight) {
        int wholeDigits = (int) weight;
        int decimalDigit = (int) ((weight - (int) weight) * 10);

        ExtendedWebElement wholePart = selectValue.format(String.valueOf(wholeDigits), "1");
        ExtendedWebElement decimalPart = selectValue.format(String.valueOf(decimalDigit), "1");


        Direction direction = (Integer.parseInt(unitValue.format("1").getText()) > wholeDigits) ? Direction.DOWN : Direction.UP;
        swipe(wholePart, numberPicker.format("1"), direction, ATTEMPTS_FIFTY, SWIPE_DURATION_LONG);

        direction = (Integer.parseInt(unitValue.format("2").getText()) > decimalDigit) ? Direction.DOWN : Direction.UP;
        swipe(decimalPart, numberPicker.format("2"), direction, ATTEMPTS_FIFTY, SWIPE_DURATION_LONG);

        return initPage(getDriver(), SetWeightPageBase.class);
    }

    @Override
    public double getWeight(String units) {
        if (!unitsSpinnerText.getText().equals(units)) {
            setUnits(units);
        }
        return Double.parseDouble(unitValue.format("1").getText() + "." + unitValue.format("2").getText());
    }

    @Override
    public ProfilePageBase saveChanges() {
        okBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
