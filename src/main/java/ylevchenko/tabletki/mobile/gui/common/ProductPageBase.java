package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;

public abstract class ProductPageBase extends TabletkiAbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FindPharmaciesPageBase findPharmacies();

}
