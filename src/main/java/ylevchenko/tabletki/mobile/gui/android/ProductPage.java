package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.FindPharmaciesPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProductPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_all_prices']")
    ExtendedWebElement searchForProductBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public FindPharmaciesPageBase findPharmacies() {
        if (!searchForProductBtn.isVisible(TIMEOUT_SHORTEST)){
            swipe(searchForProductBtn, Direction.UP, COUNT_TWO, SWIPE_DURATION_LONG);
        }
        searchForProductBtn.click();
        return initPage(getDriver(), FindPharmaciesPageBase.class);
    }

}
