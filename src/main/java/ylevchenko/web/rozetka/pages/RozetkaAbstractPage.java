package ylevchenko.web.rozetka.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import ylevchenko.web.rozetka.components.TopBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RozetkaAbstractPage extends AbstractPage {

    @FindBy(className = "header-layout")
    private TopBar topBar;

    public RozetkaAbstractPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return topBar.isUIObjectPresent();
    }

    public TopBar getTopBar() {
        return topBar;
    }

}
