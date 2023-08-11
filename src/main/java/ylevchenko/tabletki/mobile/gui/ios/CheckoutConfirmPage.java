package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.android.components.BookConfirmationModal;
import ylevchenko.tabletki.mobile.gui.common.CheckoutConfirmPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutConfirmPageBase.class)
public class CheckoutConfirmPage extends CheckoutConfirmPageBase {

    ExtendedWebElement agreeConditionsCheckbox;

    ExtendedWebElement confirmCheckout;

    BookConfirmationModal confirmationModal;

    public CheckoutConfirmPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutSucceed() {
        throw new NotImplementedException();
    }

    public String getConfirmationResult() {
        throw new NotImplementedException();
    }

}
