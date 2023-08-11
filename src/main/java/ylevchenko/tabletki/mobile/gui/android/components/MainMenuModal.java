package ylevchenko.tabletki.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractUIObject;
import ylevchenko.tabletki.mobile.gui.common.components.MainMenuModalBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuModalBase.class)
public class MainMenuModal extends TabletkiAbstractUIObject {

    @FindBy (xpath = "//android.widget.FrameLayout[@content-desc='%s']")
    ExtendedWebElement menuItem;

    public MainMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public TabletkiAbstractPage openMenuItem(MainMenuItems item) {
        menuItem.format(item.getText()).click();
        return initPage(getDriver(), item.getClassType());
    }

}
