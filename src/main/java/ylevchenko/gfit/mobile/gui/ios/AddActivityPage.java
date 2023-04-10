package ylevchenko.gfit.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.*;
import ylevchenko.gfit.mobile.gui.common.AddActivityPageBase;
import ylevchenko.gfit.mobile.gui.enums.AddActivityTextFields;
import ylevchenko.gfit.mobile.gui.enums.PlusMenuItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddActivityPageBase.class)
public class AddActivityPage extends AddActivityPageBase {

    public AddActivityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public SetActivityTypeModal openActivityTypeModal() {
        throw new NotImplementedException();
    }

    @Override
    public AddActivityPageBase inputTextField(AddActivityTextFields field, String text) {
        throw new NotImplementedException();
    }

    @Override
    public SetDateModal openSetDateModal() {
        throw new NotImplementedException();
    }

    @Override
    public SetTimeModal openSetStartTimeModal() {
        throw new NotImplementedException();
    }

    @Override
    public SetDurationModal openSetDurationModal() {
        throw new NotImplementedException();
    }

    @Override
    public SetIntensityModal openSetIntensityModal() {
        throw new NotImplementedException();
    }

    @Override
    public GFitAbstractPage saveChanges(Class<? extends GFitAbstractPage> pageClass) {
        throw new NotImplementedException();
    }

}

