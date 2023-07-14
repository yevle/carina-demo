package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.android.components.LeftMenuModal;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.LeftMenuModalBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/tab_layout']/*/*[@content-desc='%s']")
    private ExtendedWebElement homePageTab;

    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/toolBar']/*[@content-desc='Open Drawer']")
    private ExtendedWebElement leftMenuBtn;

    @FindBy(id = "navigationDrawer")
    private LeftMenuModal leftMenu;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public GsmArenaAbstractPage openLeftMenuItem(LeftMenuItems item) {
        leftMenuBtn.click();
        return leftMenu.openMenuItem(item);
    }

    public boolean isPageOpened () {
        return homePageTab.format("LATEST").isElementPresent(TIMEOUT_SHORT);
    }

}
