package ylevchenko.rozetka.gui;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.ylevchenko.rozetka.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "ylevchenko")
    @TestLabel(name = "feature", value = {"web"})
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());

        homePage.open();

        Assert.assertTrue(homePage.isPageOpened());

        homePage = homePage.getTopBar().getLoginModal().login();

        Assert.assertTrue(homePage.isLoggedIn());

    }

}
