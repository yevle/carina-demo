package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SetGenderPageBase;
import ylevchenko.gfit.mobile.gui.enums.Gender;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetGenderPageBase.class)
public class SetGenderPage extends SetGenderPageBase {

    @FindBy(xpath = "(//*[@resource-id='com.google.android.gms:id/octarine_webview_container']//*[@text='Gender'])[1]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backBtn;

    @FindBy(xpath = "//*[@class='android.widget.RadioButton'][@text='%s']")
    private ExtendedWebElement genderRadioBtn;

    public SetGenderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public SetGenderPageBase setGender(Gender gender) {
        genderRadioBtn.format(gender.getText()).click();
        return initPage(getDriver(), SetGenderPageBase.class);
    }

    @Override
    public ProfilePageBase backToProfilePage() {
        backBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
