package utilities;

import lpsim.FIXReceiver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.tradair.ClientHomePage;
import pageObjects.tradair.ClientTradingPage;
import quickfix.Application;


public class Base {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static FIXReceiver myApp;

    protected static pageObjects.tradair.LoginPage tradAirLogin;
    protected static ClientHomePage tradAirClientPage;
    protected static ClientTradingPage tradAirClientTradingPage;
    protected static ClientTradingPage bankHomePage;


    final String EUR_USD = "EUR/USD";

}
