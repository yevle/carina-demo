package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public abstract class SelectTimeModalBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {
    public SelectTimeModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void changeInputMode();

    public abstract void selectTime (LocalDate date);

}
