package ylevchenko.web.rozetka.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import ylevchenko.web.rozetka.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends RozetkaAbstractPage implements IConstants {

    @FindBy(xpath = "//p[@class='main-auth__user-caption']")
    private ExtendedWebElement userEmail;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn(){
        return userEmail.isElementWithTextPresent(LOGIN, TIMEOUT_FIVE);
    }

}
