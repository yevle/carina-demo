package ylevchenko.carina.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.android.components.MainMenu;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;

import java.util.Arrays;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//*[@content-desc='Navigate up']//following-sibling::*[@text = 'Web View']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement mainMenuBtn;

    @FindBy(xpath = "//*[(@resource-id='com.solvd.carinademoapplication:id/lin')]/*/child::*")
    private ExtendedWebElement scrollableContainer;

    @FindBy(xpath = "//*[@text='Carina - open source test automation framework']")
    private ExtendedWebElement scrollableMainContainer;

    @FindBy(xpath = "//*[(@resource-id='t-footer')]/*/child::*[5]/child::*[1]/child::*[1]")
    private ExtendedWebElement footerEmailLink;

    @FindBy(id = "image_slider")
    private ExtendedWebElement imageSlider;

    @FindBy(id = "nav_view")
    private MainMenu mainMenuModal;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenu openMainMenu() {
        if (!mainMenuModal.isMainMenuOpened()) mainMenuBtn.click();
        return mainMenuModal;
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORT);
    }

    @Override
    public boolean isFooterEmailLinkPresent() {
        return swipe(footerEmailLink, scrollableMainContainer, Direction.UP, ATTEMPTS_TEN, SWIPE_DURATION_LONG);
    }

    @Override
    public boolean isSliderVisibleAfterSwipe() {
        swipeUp(ATTEMPTS_FIVE, SWIPE_DURATION_LONG);
        return imageSlider.isVisible(TIMEOUT_SHORT);
    }

    @Override
    public boolean isFooterEmailLinkCorrect(String name, String domain) {
        String emailText = footerEmailLink.getText();
        return Arrays.stream(emailText.strip().split("@"))
                .allMatch(text -> text.equals(name) || text.equals(domain));
    }

}
