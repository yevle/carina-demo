package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;

public abstract class CheckoutConfirmPageBase extends TabletkiAbstractPage {

    public CheckoutConfirmPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCheckoutSucceed();

    public abstract String getConfirmationResult();

}
