package ylevchenko.gfit.mobile.gui.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.common.JournalEntityPageBase;

public abstract class MoreOptionsModalBase extends AbstractUIObject implements ICustomTypePageFactory {

    public MoreOptionsModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract JournalEntityPageBase deleteEntity();

}
