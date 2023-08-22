package ylevchenko.mapmyrun.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.mapmyrun.mobile.gui.common.SignUpPageBase;
import ylevchenko.mapmyrun.mobile.gui.enums.Gender;
import ylevchenko.mapmyrun.mobile.gui.utils.MobileShellCommands;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/email']//android.widget.EditText")
    ExtendedWebElement emailTextField;

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/Name']//android.widget.EditText")
    ExtendedWebElement firstNameTextField;

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/lName']//android.widget.EditText")
    ExtendedWebElement lastNameTextField;

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/birthdate']//android.widget.EditText")
    ExtendedWebElement birthdayField;

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/genderDropdownMenu']//android.widget.ImageButton")
    ExtendedWebElement genderDropdown;

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/location']//android.widget.ImageButton")
    ExtendedWebElement countryDropdown;

    @FindBy(xpath = "//*[@resource-id='com.mapmyrun.android2:id/password']//android.widget.EditText")
    ExtendedWebElement passwordTextField;

    ExtendedWebElement signUpBtn;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPageBase setGender(Gender gender){
        MobileShellCommands cmd = new MobileShellCommands();
        genderDropdown.click();
        cmd.pressDown(gender.getIndex());
        cmd.pressEnter();
        return  initPage(getDriver(), SignUpPageBase.class);
    }

    public SignUpPageBase setCountry(){
        MobileShellCommands cmd = new MobileShellCommands();
        countryDropdown.click();
        cmd.pressDown(30);
        cmd.pressEnter();
        return  initPage(getDriver(), SignUpPageBase.class);
    }

}
