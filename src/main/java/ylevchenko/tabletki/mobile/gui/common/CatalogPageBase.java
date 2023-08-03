package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.enums.SortingOrder;

public abstract class CatalogPageBase extends TabletkiAbstractPage {

    public CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogPageBase sortBy(SortingOrder order);

    public abstract boolean isSortedBy(SortingOrder order);

}
