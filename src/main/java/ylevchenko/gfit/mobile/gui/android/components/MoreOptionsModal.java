package ylevchenko.gfit.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;
import ylevchenko.gfit.mobile.gui.common.components.MoreOptionsModalBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreOptionsModalBase.class)
public class MoreOptionsModal extends MoreOptionsModalBase {

    @FindBy(xpath = "//*[@resource-id='android:id/button1'][@text='{L10N:delete}']")
    ExtendedWebElement deleteBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/content']//*[@text='{L10N:delete}']")
    ExtendedWebElement deleteField;

    public MoreOptionsModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public JournalEntityPageBase deleteEntity() {
        deleteField.click();
        return initPage(getDriver(), JournalEntityPageBase.class);
    }

}
