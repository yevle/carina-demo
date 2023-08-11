package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.android.components.ChooseQtyModal;
import ylevchenko.tabletki.mobile.gui.android.components.Pharmacy;
import ylevchenko.tabletki.mobile.gui.common.CartPageBase;
import ylevchenko.tabletki.mobile.gui.common.FindPharmaciesPageBase;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FindPharmaciesPageBase.class)
public class FindPharmaciesPage extends FindPharmaciesPageBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_radius']")
    ExtendedWebElement addedRadiusTab;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_filter_name'][@text='все місто']")
    ExtendedWebElement allCityRadTab;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='ПОКАЗАТИ РЕЗУЛЬТАТИ']")
    ExtendedWebElement showResultsBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_title'][contains(@text,'не знайдено')]")
    ExtendedWebElement notFoundText;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/main_layout']")
    List<Pharmacy> pharmacies;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/design_bottom_sheet']")
    ChooseQtyModal chooseQtyModal;

    public FindPharmaciesPage(WebDriver driver) {
        super(driver);
    }

    private void removeRadius() {
        addedRadiusTab.click();
        allCityRadTab.click();
        showResultsBtn.click();
    }

    public CartPageBase addQtyToCart(int qty) {
        if (notFoundText.isPresent()) {
            removeRadius();
        }
        for (int i = 0; i < COUNT_FIVE; i++) {
            swipeUp(COUNT_ONE, SWIPE_DURATION_LONG);
            if (pharmacies.get(i).reserve()) {
                break;
            }
        }
        chooseQtyModal.addToCartAndProceed(qty);
        return initPage(getDriver(), CartPageBase.class);
    }

}
