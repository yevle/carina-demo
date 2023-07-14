package ylevchenko.gsmarena.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.BeforeTest;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

public class BaseTest implements IMobileUtils, IAbstractTest {

    private String login = "john_tak_@ukr.net";
    private String pass = "john_tak_";
    @BeforeTest
    public void loginApp() {
        ((ProfilePageBase)initPage(getDriver(), NewsPageBase.class).openLeftMenuItem(LeftMenuItems.PROFILE)).loginWithCreds(login, pass);
    }

}
