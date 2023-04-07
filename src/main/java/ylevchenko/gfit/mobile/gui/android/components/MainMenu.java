package ylevchenko.gfit.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.components.PlusMenuBase;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlusMenuBase.class)
public class PlusMenu extends PlusMenuBase {

    @FindBy(id = "nav_view")
    private ExtendedWebElement container;

    @FindBy(xpath = "*//android.widget.CheckedTextView[contains(@text,'%s')]")
    private ExtendedWebElement menuItem;

    public PlusMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPlusMenuElementPresent(PlusMenuItems menuItem) {
        return false;
    }

    @Override
    public List<String> getPlusMenuList() {
        return null;
    }

    @Override
    public ExtendedWebElement getPlusMenuItem(int index) {
        return null;
    }

    @Override
    public GFitAbstractPage openPlusMenuItem(PlusMenuItems item) {
        return null;
    }

    @Override
    public GFitAbstractPage openMenuItemByIndex(int index) {
        return null;
    }

    @Override
    public List<ExtendedWebElement> getPlusMenuItems() {
        return null;
    }

    @Override
    public boolean isPlusMenuOpened() {
        return false;
    }

    @Override
    public void tapOutsidePlusMenuItems() {

    }

    @Override
    public void closePlusMenu() {

    }
}
