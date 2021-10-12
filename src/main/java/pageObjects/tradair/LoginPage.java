package pageObjects.tradair;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID, using = "username")
    public WebElement txt_userName;

    @FindBy(how = How.ID, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CLASS_NAME, using = "button")
    public WebElement btn_login;



    // Your connection is not private Section
    @FindBy(how = How.ID, using = "details-button")
    public WebElement btn_advanced;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Proceed to local-leonidb.tradair.com")
    public WebElement btn_proceedToLocalhost;

    @FindBy(how = How.ID, using = "main-message")
    public WebElement header_mainMessage;




}
