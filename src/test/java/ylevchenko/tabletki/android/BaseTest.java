package ylevchenko.tabletki.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.BeforeTest;
import ylevchenko.tabletki.mobile.gui.common.MainPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProfilePageBase;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

public class BaseTest implements IMobileUtils, IAbstractTest {

    @BeforeTest
    public void loginApp() {
        ((ProfilePageBase)(initPage(getDriver(), MainPageBase.class).openMenuItem(MainMenuItems.PROFILE)))
                .openLoginPage().loginWithCreds(R.TESTDATA.get("tabletki_login"), R.TESTDATA.get("tabletki_pass"))
                .openMenuItem(MainMenuItems.MAIN);

    }



}
