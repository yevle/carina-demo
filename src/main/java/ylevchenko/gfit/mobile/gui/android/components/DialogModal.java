package ylevchenko.gfit.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.components.DialogModalBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DialogModalBase.class)
public class DialogModal extends DialogModalBase {

    @FindBy(xpath = "//*[@resource-id='android:id/button1'][@text='{L10N:delete}']")
    ExtendedWebElement deleteBtn;

    public DialogModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public JournalPageBase delete() {
        deleteBtn.click();
        return initPage(getDriver(), JournalPageBase.class);
    }

}
