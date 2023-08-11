package ylevchenko.tabletki.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.android.components.MainMenuModal;
import ylevchenko.tabletki.mobile.gui.android.components.SearchModal;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.common.MainPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProductPageBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    MainMenuModal mainMenu;

    ExtendedWebElement searchField;

    SearchModal searchModal;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public TabletkiAbstractPage openMenuItem(MainMenuItems items) {
        return mainMenu.openMenuItem(items);
    }

    public CatalogPageBase search(String keyword) {
        throw new NotImplementedException();
    }

    public ProductPageBase searchProduct(String keyword) {
        throw new NotImplementedException();
    }

}
