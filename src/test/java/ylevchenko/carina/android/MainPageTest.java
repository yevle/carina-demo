package ylevchenko.carina.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import ylevchenko.carina.mobile.gui.common.WelcomePageBase;
import ylevchenko.carina.mobile.gui.service.IConstants;

public class MainPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @BeforeTest
    public void openAppAndLogin() {
        initPage(getDriver(), WelcomePageBase.class).clickNextBtn().login();
    }

    @Test(description = "Main page scroll and email link test")
    @MethodOwner(owner = "ylevchenko")
    public void pageScrollToEmailTest() {

        SoftAssert softAssert = new SoftAssert();

        String emailName = "support";
        String emailDomain = "zebrunner.com";

        WebViewPageBase mainMenuPage = initPage(getDriver(), WebViewPageBase.class);

        Assert.assertTrue(mainMenuPage.isPageOpened(), "[MAIN PAGE] - Main page isn't opened");

        softAssert.assertTrue(mainMenuPage.isSliderVisibleAfterSwipe(), "[MAIN PAGE] - Image slider isn't visible");
        softAssert.assertTrue(mainMenuPage.isFooterEmailLinkPresent(),"[MAIN PAGE] - Footer email link isn't present");
        softAssert.assertTrue(mainMenuPage.isFooterEmailLinkCorrect(emailName, emailDomain),
                "[MAIN PAGE] - Footer email text isn't correct");

        softAssert.assertAll();
    }

}
