package ylevchenko.web.rozetka.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBar extends AbstractUIObject {

//    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--user']/*")
    @FindBy(xpath = "//li[contains(@class,'header-actions__item--user')]/*")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'modal__holder')]")
    private LoginModal loginModal;

    public TopBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginModal getLoginModal() {
        loginButton.click();
        return loginModal;
    }

}
