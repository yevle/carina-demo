package ylevchenko.tabletki.mobile.gui.ios.components;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;
import ylevchenko.tabletki.mobile.gui.common.components.ChooseQtyModalBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ChooseQtyModalBase.class)
public class ChooseQtyModal extends ChooseQtyModalBase {

    ExtendedWebElement plusBtn;

    ExtendedWebElement minusBtm;

    ExtendedWebElement qtyText;

    ExtendedWebElement priceText;

    ExtendedWebElement proceedToCartBtn;

    ExtendedWebElement continueShopBtn;

    public ChooseQtyModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageBase addToCartAndProceed(int qty) {
        throw new NotImplementedException();
    }

}
