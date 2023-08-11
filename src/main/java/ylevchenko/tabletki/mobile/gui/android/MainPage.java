package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.android.components.MainMenuModal;
import ylevchenko.tabletki.mobile.gui.android.components.SearchModal;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.common.MainPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProductPageBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy (xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/bottom_navigation']")
    MainMenuModal mainMenu;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/et_search']")
    ExtendedWebElement searchField;

    @FindBy(xpath = "//*[@resource-id='android:id/content']")
    SearchModal searchModal;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public TabletkiAbstractPage openMenuItem(MainMenuItems items) {
        return mainMenu.openMenuItem(items);
    }

    public CatalogPageBase search(String keyword) {
        searchField.click();
        return searchModal.searchMeds(keyword);
    }

    public ProductPageBase searchProduct(String keyword) {
        searchField.click();
        return searchModal.openProduct(keyword);
    }

}
