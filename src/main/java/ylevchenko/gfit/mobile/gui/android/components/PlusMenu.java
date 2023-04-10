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

    @FindBy(id = "add_entry_speed_dial")
    private ExtendedWebElement container;

    @FindBy(xpath = "//*[(@resource-id='com.google.android.apps.fitness:id/mtrl_internal_speed_dial_item')]/*[@text='%s']/parent::*")
    private ExtendedWebElement menuItem;

    @FindBy(xpath = "//*[(@resource-id='com.google.android.apps.fitness:id/mtrl_internal_speed_dial_item')]")
    private List<ExtendedWebElement> menuItems;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close menu']")
    private ExtendedWebElement closeBtn;

    public PlusMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GFitAbstractPage openPlusMenuItem(PlusMenuItems item) {
        menuItem.format(item.getText()).click();
        return initPage(getDriver(), item.getPageClass());
    }

    @Override
    public void closePlusMenu() {
        closeBtn.click();
    }

}
