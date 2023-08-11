package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;

public abstract class CartPageBase extends TabletkiAbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutConfirmPageBase finishCheckout();

}
