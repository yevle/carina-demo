package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.android.components.BookConfirmationModal;
import ylevchenko.tabletki.mobile.gui.common.CheckoutConfirmPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutConfirmPageBase.class)
public class CheckoutConfirmPage extends CheckoutConfirmPageBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/checkbox'][contains(@text,'Я згоден')]")
    ExtendedWebElement agreeConditionsCheckbox;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_make_reservation']")
    ExtendedWebElement confirmCheckout;

    @FindBy(xpath = "//*[@resource-id='android:id/content']")
    BookConfirmationModal confirmationModal;

    public CheckoutConfirmPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutSucceed() {
        if (!agreeConditionsCheckbox.isChecked()) {agreeConditionsCheckbox.check();}
        confirmCheckout.click();
        return confirmationModal.isBookingSucceed();
    }

    public String getConfirmationResult() {
        if (!agreeConditionsCheckbox.isChecked()) {agreeConditionsCheckbox.check();}
        confirmCheckout.click();
        return confirmationModal.getResultMsg();
    }

}
