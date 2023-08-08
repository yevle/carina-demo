package ylevchenko.gfit.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.BeforeTest;
import ylevchenko.gfit.mobile.gui.common.LoginPageBase;
import ylevchenko.gfit.mobile.gui.service.IConstants;

public class BaseTest implements IAbstractTest, IMobileUtils, IConstants {

    @BeforeTest
    public void loginApp() {
        initPage(getDriver(), LoginPageBase.class).login().clickNextBtn().clickSkipBtn();
    }

}
