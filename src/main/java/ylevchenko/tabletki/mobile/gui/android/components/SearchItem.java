package ylevchenko.tabletki.mobile.gui.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.components.SearchItemBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchItemBase.class)
public class SearchItem extends SearchItemBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_name']")
    ExtendedWebElement title;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_price']")
    ExtendedWebElement price;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getTitle() {
        if (!swipe(title, Direction.UP, ATTEMPTS_ONE, SWIPE_DURATION_LONG)) {
            return "";
        }
        return title.getText();
    }

    public double getPrice() {
        if (!price.isVisible(TIMEOUT_SHORTEST)) {
            swipe(price, Direction.UP, ATTEMPTS_ONE, SWIPE_DURATION_LONG);
            if (!price.isVisible(TIMEOUT_SHORTEST)) {
                return 0;
            }
        }
        return price.getText().replaceAll("[^0-9.]", "").isEmpty() ?
                0 : Double.parseDouble(price.getText().replaceAll("[^0-9.]", ""));
    }

}
