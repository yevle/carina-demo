package ylevchenko.gfit.mobile.gui.common;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;

public abstract class SetWeightPageBase extends GFitAbstractPage implements ICustomTypePageFactory, IMobileUtils {

    public SetWeightPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SetWeightPageBase setUnits(String units);

    public abstract SetWeightPageBase setWeight(double weight);

    public abstract double getWeight(String units);

    public abstract ProfilePageBase saveChanges();

}
