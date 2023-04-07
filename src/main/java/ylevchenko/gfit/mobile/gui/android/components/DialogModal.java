package ylevchenko.gfit.mobile.gui.android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.components.MoreOptionsModalBase;
import ylevchenko.gfit.mobile.gui.common.components.PlusMenuBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreOptionsModalBase.class)
public class MoreOptionsModal extends MoreOptionsModalBase {

    public MoreOptionsModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public JournalPageBase deleteEntity() {
        return in;
    }
}
