package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void initTradAir(){
        tradAirLogin = PageFactory.initElements(driver, pageObjects.tradair.LoginPage.class);
        tradAirClientPage = PageFactory.initElements(driver, pageObjects.tradair.ClientHomePage.class);
        tradAirClientTradingPage = PageFactory.initElements(driver, pageObjects.tradair.ClientTradingPage.class);

        //bankHomePage = PageFactory.initElements(driver, pageObjects.tradair.BankHomePage.class);
    }

}
