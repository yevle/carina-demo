package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;
import ylevchenko.tabletki.mobile.gui.common.CheckoutConfirmPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    ExtendedWebElement finishCheckoutBtn;

    ExtendedWebElement summaryField;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutConfirmPageBase finishCheckout() {
        throw new NotImplementedException();
    }

}
