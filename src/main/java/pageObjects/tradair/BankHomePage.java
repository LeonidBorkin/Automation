package pageObjects.tradair;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankHomePage {

    // Top Panel Tabs
    @FindBy(how = How.LINK_TEXT, using = "Streamer")
    public static WebElement topPanelTab_Streamer;

    @FindBy(how = How.LINK_TEXT, using = "FastTrader")
    public static WebElement topPanelTab_FastTrader;

    @FindBy(how = How.LINK_TEXT, using = "Trading")
    public static WebElement topPanelTab_Trading;

    @FindBy(how = How.LINK_TEXT, using = "Rate Engine")
    public static WebElement topPanelTab_RateEngine;

    @FindBy(how = How.LINK_TEXT, using = "Sales")
    public static WebElement topPanelTab_Sales;

    @FindBy(how = How.LINK_TEXT, using = "Reports")
    public static WebElement topPanelTab_Reports;

    @FindBy(how = How.LINK_TEXT, using = "Monitor")
    public static WebElement topPanelTab_Monitor;

}
