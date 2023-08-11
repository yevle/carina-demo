package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;

public abstract class FindPharmaciesPageBase extends TabletkiAbstractPage {

    public FindPharmaciesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase addQtyToCart(int qty);

}
