package pageObjects.tradair;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ClientHomePage {

    // Logo
    @FindBy(how = How.CLASS_NAME, using = "taSprite_logoImage1")
    public static WebElement topPanelTab_Logo;


    // Top Panel Tabs

    @FindBy(how = How.LINK_TEXT, using = "FastTrader")
    public static WebElement topPanelTab_FastTrader;

    @FindBy(how = How.LINK_TEXT, using = "Trading")
    public static WebElement topPanelTab_Trading;






}
