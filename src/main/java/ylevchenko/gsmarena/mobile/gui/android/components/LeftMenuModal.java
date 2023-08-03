package ylevchenko.gsmarena.mobile.gui.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.common.components.LeftMenuModalBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LeftMenuModalBase.class)
public class LeftMenuModal extends LeftMenuModalBase {

    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/design_menu_item_text'][contains(@text,'%s')]")
    private ExtendedWebElement menuItem;

    public LeftMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public GsmArenaAbstractPage openMenuItem (LeftMenuItems item) {
        menuItem.format(item.getText()).click();
        return initPage(getDriver(), item.getClassType());
    }


}
