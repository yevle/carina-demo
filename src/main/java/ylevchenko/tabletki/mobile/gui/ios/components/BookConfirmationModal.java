package ylevchenko.tabletki.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.components.BookConfirmationModalBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BookConfirmationModalBase.class)
public class BookConfirmationModal extends BookConfirmationModalBase {

    ExtendedWebElement confirmationMsg;

    ExtendedWebElement resultMsg;

    ExtendedWebElement goToBookingsBtn;

    public BookConfirmationModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBookingSucceed() {
        throw new NotImplementedException();
    }

    public String getResultMsg() {
        throw new NotImplementedException();
    }

}
