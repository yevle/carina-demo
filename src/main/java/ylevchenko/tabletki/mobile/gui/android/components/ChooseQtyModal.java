package ylevchenko.tabletki.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;
import ylevchenko.tabletki.mobile.gui.common.components.ChooseQtyModalBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChooseQtyModalBase.class)
public class ChooseQtyModal extends ChooseQtyModalBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/iv_add']")
    ExtendedWebElement plusBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/iv_remove']")
    ExtendedWebElement minusBtm;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_count']")
    ExtendedWebElement qtyText;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_price']")
    ExtendedWebElement priceText;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_show_results']")
    ExtendedWebElement proceedToCartBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_next']")
    ExtendedWebElement continueShopBtn;

    public ChooseQtyModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageBase addToCartAndProceed(int qty) {
        ExtendedWebElement btnToClick = Integer.parseInt(qtyText.getText()) < qty ? plusBtn : minusBtm;
        while (Integer.parseInt(qtyText.getText()) != qty) {
            btnToClick.click();
        }
        proceedToCartBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

}
