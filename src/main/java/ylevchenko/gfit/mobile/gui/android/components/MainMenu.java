package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.components.MainMenuBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase {

    @FindBy(id = "bottom_navigation")
    private ExtendedWebElement container;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='%s']")
    private ExtendedWebElement menuItem;

    public MainMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GFitAbstractPage openMainMenuItem(MainMenuItems item) {
        menuItem.format(item.getText()).click();
        return (initPage(getDriver(), JournalPageBase.class));
    }

    @Override
    public List<ExtendedWebElement> getMainMenuItems() {
        return null;
    }


}
