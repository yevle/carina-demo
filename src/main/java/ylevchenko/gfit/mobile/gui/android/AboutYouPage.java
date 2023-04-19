package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.AboutYouPageBase;
import ylevchenko.gfit.mobile.gui.common.TrackActivitiesPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutYouPageBase.class)
public class AboutYouPage extends AboutYouPageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/heart_logo_animation']//following-sibling::*[@text = 'About you']")
    private ExtendedWebElement title;

    @FindBy(id = "%s_field")
    private ExtendedWebElement parameterItem;

    @FindBy(id = "sign_in_button")
    private ExtendedWebElement signInBtn;

    @FindBy(id = "next_button")
    private ExtendedWebElement nextBtn;

    public AboutYouPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORTEST);
    }

    public TrackActivitiesPageBase clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), TrackActivitiesPageBase.class);
    }

}
