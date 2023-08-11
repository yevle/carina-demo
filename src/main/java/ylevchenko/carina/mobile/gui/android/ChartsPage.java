package ylevchenko.carina.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.android.components.MainMenu;
import ylevchenko.carina.mobile.gui.common.ChartsPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(xpath = "//*[@content-desc='Navigate up']//following-sibling::*[@text = 'Charts']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement mainMenuBtn;

    @FindBy(id = "nav_view")
    private MainMenu mainMenuModal;

    @FindBy(id = "image_slider")
    private ExtendedWebElement imageSlider;

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenu openMainMenu() {
        if(!mainMenuModal.isMainMenuOpened()) mainMenuBtn.click();
        return mainMenuModal;
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORT);
    }

    @Override
    public boolean isSliderVisibleAfterSwipe() {
        swipeDown(ATTEMPTS_FIVE, SWIPE_DURATION_LONG);
        return imageSlider.isVisible(TIMEOUT_SHORT);
    }

}
