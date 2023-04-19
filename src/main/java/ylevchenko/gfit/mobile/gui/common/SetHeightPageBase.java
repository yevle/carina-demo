package ylevchenko.gfit.mobile.gui.common;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class SetHeightPageBase extends GFitAbstractPage implements ICustomTypePageFactory, IMobileUtils {

    public SetHeightPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SetHeightPageBase setUnits(String units);

    public abstract SetHeightPageBase setHeight(int height);

    public abstract int getHeight();

    public abstract ProfilePageBase saveChanges();

    public abstract String getHeightFt();

}
