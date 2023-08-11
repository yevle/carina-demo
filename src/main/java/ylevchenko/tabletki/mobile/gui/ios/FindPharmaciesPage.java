package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.android.components.ChooseQtyModal;
import ylevchenko.tabletki.mobile.gui.android.components.Pharmacy;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;
import ylevchenko.tabletki.mobile.gui.common.FindPharmaciesPageBase;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FindPharmaciesPageBase.class)
public class FindPharmaciesPage extends FindPharmaciesPageBase {

    ExtendedWebElement addedRadiusTab;

    ExtendedWebElement allCityRadTab;

    ExtendedWebElement showResultsBtn;

    ExtendedWebElement notFoundText;

    List<Pharmacy> pharmacies;

    ChooseQtyModal chooseQtyModal;

    public FindPharmaciesPage(WebDriver driver) {
        super(driver);
    }

    private void removeRadius() {
        throw new NotImplementedException();
    }

    public CartPageBase addQtyToCart(int qty) {
        throw new NotImplementedException();
    }

}
