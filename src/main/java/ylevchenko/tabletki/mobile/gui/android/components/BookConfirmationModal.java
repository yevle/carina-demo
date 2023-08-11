package ylevchenko.tabletki.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.components.BookConfirmationModalBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BookConfirmationModalBase.class)
public class BookConfirmationModal extends BookConfirmationModalBase {

    @FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView[contains(@text,'Бронювання надіслано')]")
    ExtendedWebElement confirmationMsg;

    @FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView[1]")
    ExtendedWebElement resultMsg;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_go_to_reserves']")
    ExtendedWebElement goToBookingsBtn;

    public BookConfirmationModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBookingSucceed() {
        return confirmationMsg.isElementPresent(TIMEOUT_SHORT);
    }

    public String getResultMsg() {
        return resultMsg.getText();
    }

}
