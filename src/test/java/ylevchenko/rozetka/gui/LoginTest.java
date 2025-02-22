package ylevchenko.rozetka.gui;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.web.rozetka.pages.HomePage;

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
