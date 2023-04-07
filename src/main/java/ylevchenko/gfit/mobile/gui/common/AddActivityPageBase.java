package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.*;
import ylevchenko.gfit.mobile.gui.enums.AddActivityTextFields;

public abstract class AddActivityPageBase extends GFitAbstractPage {

    public AddActivityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SetActivityTypeModal openActivityTypeModal();

    public abstract AddActivityPageBase inputTextField(AddActivityTextFields field, String text);

    public abstract SetDateModal openSetDateModal();

    public abstract SetTimeModal openSetStartTimeModal();

    public abstract SetDurationModal openSetDurationModal();

    public abstract SetIntensityModal openSetIntensityModal();

    public abstract boolean closePage();

    public abstract GFitAbstractPage saveChanges(Class<? extends GFitAbstractPage> pageClass);

}
