package ylevchenko.gsmarena.mobile.gui.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.FavoritesItemBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FavoritesItemBase.class)
public class FavoritesItem extends FavoritesItemBase {

    @FindBy(xpath = "//android.view.View/*/android.view.View[contains(@text,'')]")
    private ExtendedWebElement title;

    public FavoritesItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public void swipeToElement() {
        if (!title.isVisible(TIMEOUT_SHORT)) {
            swipe(title, Direction.UP, ATTEMPTS_FIVE, SWIPE_DURATION_LONG);
        }
    }

    public DevicePageBase openFavorite() {
        title.click();
        return initPage(getDriver(), DevicePageBase.class);
    }

}
