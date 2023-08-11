package ylevchenko.gsmarena.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DevicePageBase.class)
public class DevicePage extends DevicePageBase {

    @FindBy(xpath = "//*[@resource-id='fan-vote']")
    private ExtendedWebElement favouriteBtn;

    @FindBy(xpath = "//*[@resource-id='fan-vote']//android.widget.TextView[contains(@text,'fan')]")
    private ExtendedWebElement fanText;

    @FindBy(xpath = "//*[@resource-id='content']/*[contains(@text,'')][1]")
    private ExtendedWebElement title;

    public DevicePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DevicePageBase addToFavourites() {
        if (!fanText.getText().equals(FAVORITE_TEXT)) {
            favouriteBtn.click(TIMEOUT_SHORT);
        }
        return initPage(getDriver(), DevicePageBase.class);
    }

    public DevicePageBase removeFromFavourites() {
        if (fanText.getText().equals(FAVORITE_TEXT)) {
            favouriteBtn.click(TIMEOUT_SHORT);
        }
        return initPage(getDriver(), DevicePageBase.class);
    }

    public String getTitle() {
        return title.getText();
    }

    public SearchPageBase goBackToSearch() {
        navigateBack();
        return initPage(getDriver(), SearchPageBase.class);
    }

    public ProfilePageBase goBackToProfile() {
        navigateBack();
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
