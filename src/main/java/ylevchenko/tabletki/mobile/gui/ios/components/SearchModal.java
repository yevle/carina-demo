package ylevchenko.tabletki.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProductPageBase;
import ylevchenko.tabletki.mobile.gui.common.components.SearchModalBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchModalBase.class)
public class SearchModal extends SearchModalBase {

    ExtendedWebElement searchTextField;

    ExtendedWebElement firstGroup;

    ExtendedWebElement firstProduct;

    public SearchModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogPageBase searchMeds(String keyword){
        throw new NotImplementedException();
    }

    public ProductPageBase openProduct(String keyword){
        throw new NotImplementedException();
    }

}
