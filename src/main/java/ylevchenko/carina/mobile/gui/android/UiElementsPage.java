package ylevchenko.carina.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.carina.mobile.gui.android.components.MainMenu;
import ylevchenko.carina.mobile.gui.common.UiElementsPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UiElementsPageBase.class)
public class UiElementsPage extends UiElementsPageBase {

    @FindBy(xpath = "//*[@content-desc='Navigate up']//following-sibling::*[@text = 'UI elements']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement mainMenuBtn;

    @FindBy(id = "nav_view")
    private MainMenu mainMenuModal;

    public UiElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenu tapMainMenuButton() {
        mainMenuBtn.click();
        return mainMenuModal;
    }

    @Override
    public void scrollToFooter() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFooterEmailLinkPresent() {
        return false;
    }

    public boolean isPageOpened() {
        return title.isElementPresent(TIMEOUT_SHORT);
    }

    @Override
    public boolean isImageSliderVisible() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFooterEmailLinkCorrect() {
        throw new NotImplementedException();
    }
}
