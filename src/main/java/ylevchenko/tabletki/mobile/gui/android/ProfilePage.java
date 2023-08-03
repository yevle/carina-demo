package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.android.components.MainMenuModal;
import ylevchenko.tabletki.mobile.gui.common.LoginPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProfilePageBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy (xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/btn_sing_in']")
    ExtendedWebElement loginBtn;

    @FindBy (xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/bottom_navigation']")
    MainMenuModal mainMenu;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public LoginPageBase openLoginPage () {
        loginBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    public TabletkiAbstractPage openMenuItem(MainMenuItems items) {
        return mainMenu.openMenuItem(items);
    }

}
