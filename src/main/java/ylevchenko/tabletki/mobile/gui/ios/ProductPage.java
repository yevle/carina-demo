package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.FindPharmaciesPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProductPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    ExtendedWebElement searchForProductBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public FindPharmaciesPageBase findPharmacies() {
        throw new NotImplementedException();
    }

}
