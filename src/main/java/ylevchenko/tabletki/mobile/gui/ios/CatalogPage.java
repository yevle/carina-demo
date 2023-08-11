package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.android.components.SearchItem;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.enums.SortingOrder;

import java.util.LinkedHashSet;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {

    ExtendedWebElement searchTitle;

    List<SearchItem> searchItemsList;

    ExtendedWebElement sortingDropdownBtn;

    ExtendedWebElement sortingOption;

    ExtendedWebElement showMoreBtn;

    ExtendedWebElement resultsCount;

    ExtendedWebElement container;

    LinkedHashSet<Double> pricesSet;

    LinkedHashSet<String> titlesSet;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPageBase sortBy(SortingOrder order) {
        throw new NotImplementedException();
    }

    public List<Double> getPricesList() {
        throw new NotImplementedException();
    }

    public List<String> getTitlesList() {
        throw new NotImplementedException();
    }

    public boolean isSortedBy(SortingOrder order) {
        throw new NotImplementedException();
    }

    public String getTitle() {
        throw new NotImplementedException();
    }

}
