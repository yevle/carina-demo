package ylevchenko.gsmarena.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.SpecsItemBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SpecsItemBase.class)
public class SpecsItem extends SpecsItemBase {

    @FindBy(xpath = "*//android.view.View")
    private ExtendedWebElement title;

    public SpecsItem(WebDriver driver, SearchContext searchContext) {
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
        title.click(TIMEOUT_SHORT);
        return initPage(getDriver(), DevicePageBase.class);
    }

}
