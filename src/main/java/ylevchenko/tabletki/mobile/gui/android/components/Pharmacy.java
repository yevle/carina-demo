package ylevchenko.tabletki.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.components.PharmacyBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PharmacyBase.class)
public class Pharmacy extends PharmacyBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_add_to_cart_text']")
    ExtendedWebElement orderBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_price']")
    ExtendedWebElement priceText;

    public Pharmacy(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean reserve() {
        if (!orderBtn.isPresent(TIMEOUT_SHORTEST)) {return false;}
        orderBtn.click();
        return true;
    }

}
