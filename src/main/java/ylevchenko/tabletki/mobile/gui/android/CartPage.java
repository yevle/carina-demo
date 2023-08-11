package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;
import ylevchenko.tabletki.mobile.gui.common.CheckoutConfirmPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_make_reservation']")
    ExtendedWebElement finishCheckoutBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_total_price']")
    ExtendedWebElement summaryField;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutConfirmPageBase finishCheckout() {
        finishCheckoutBtn.click();
        return initPage(getDriver(), CheckoutConfirmPageBase.class);
    }

}
