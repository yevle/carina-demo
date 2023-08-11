package ylevchenko.tabletki.mobile.gui.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractUIObject;

public abstract class BookConfirmationModalBase extends TabletkiAbstractUIObject {

    public BookConfirmationModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isBookingSucceed();

}
