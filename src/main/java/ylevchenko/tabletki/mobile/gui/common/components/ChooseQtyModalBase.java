package ylevchenko.tabletki.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractUIObject;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;

public abstract class ChooseQtyModalBase extends TabletkiAbstractUIObject {

    public ChooseQtyModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CartPageBase addToCartAndProceed(int qty);

}
