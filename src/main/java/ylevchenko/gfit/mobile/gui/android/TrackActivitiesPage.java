package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.common.TrackActivitiesPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TrackActivitiesPageBase.class)
public class TrackActivitiesPage extends TrackActivitiesPageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/heart_logo']//following-sibling::*[@text = 'Track your activities']")
    private ExtendedWebElement title;

    @FindBy(id = "skip_button")
    private ExtendedWebElement skipBtn;

    public TrackActivitiesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORTEST);
    }

    public MainPageBase clickSkipBtn() {
        if (skipBtn.isElementNotPresent(TIMEOUT_SHORT)) {
            swipeUp(SWIPE_DURATION_LONG);
        }
        skipBtn.click();
        return initPage(getDriver(), MainPageBase.class);
    }

}
