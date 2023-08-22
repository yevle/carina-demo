package ylevchenko.mapmyrun.android;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.mapmyrun.mobile.gui.common.SignUpPageBase;
import ylevchenko.mapmyrun.mobile.gui.common.WelcomePageBase;

public class SignUpTest implements IMobileUtils, IAbstractTest {

    @Test(description = "Sighn Up in the app")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void signUpTest() {

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened());

        SignUpPageBase signUpPage = welcomePage.signUp();

        signUpPage.setCountry();

    }
}
