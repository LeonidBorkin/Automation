package workflows;

import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Step;
import lpsim.FIXReceiver;
import lpsim.ReceiverApp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.tradair.ClientHomePage;
import pageObjects.tradair.LoginPage;
import quickfix.*;
import utilities.CommonOps;

import static pageObjects.tradair.ClientTradingPage.*;

public class WebFlow extends CommonOps {

    public static void runReceiverApp(Message msg, SessionID sessionID) throws UnsupportedMessageType, IncorrectTagValue, FieldNotFound, IncorrectDataFormat {


    }


    @Step("Tradair Web Flow: skip Connection Is Not Private")
    public static void skipConnectionIsNotPrivate(){
        System.out.println("----------------------------------------------------- Running Leon's Local Machine -----------------------------------------------------");
        if (tradAirLogin.header_mainMessage.isDisplayed()){
            UIActions.click(tradAirLogin.btn_advanced);
            UIActions.click(tradAirLogin.btn_proceedToLocalhost);
        }
        else {
            System.out.println("Your Connection is Private SSL");
        }
    }

    @Step("Tradair Web Flow: Verify Home Page Logo")
    public static void VerifyLogo(){
        Verifications.verifyVisibilityOfElement(ClientHomePage.topPanelTab_Logo);
    }

    public static void createNewUser(){
        //UIActions.click();

    }

    @Step ("Login Into TradAir Account")
    public static void loginTradAir(String userName, String password){
        UIActions.updateText(tradAirLogin.txt_userName, userName);
        UIActions.updateText(tradAirLogin.txt_password, password);
        UIActions.click(tradAirLogin.btn_login);
    }

    public static void SetWidget(String ccpPair, String platform, String tif, String mode){

        // after login with user
        //
        //- switch tab to Trading
        //
        //- click set icon
        //
        //- update 4 dropdowns
        //
        //- click set icon
    }

    public static void getRates(String currency, WebElement sell, WebElement buy){

        wait.until(ExpectedConditions.visibilityOf(sell));
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(sell));
        wait.until(ExpectedConditions.visibilityOf(buy));
        System.out.println(String.format("%s price is -\n Sell: " + sell.getText() + " and Buy: " + buy.getText(), currency));

    }

    public static void getWidgetFullPrice(String currency, WebElement pre, WebElement big, WebElement post){
        wait.until(ExpectedConditions.visibilityOf(pre));
        wait.until(ExpectedConditions.visibilityOf(big));
        wait.until(ExpectedConditions.visibilityOf(post));

        String preNum1  = pre.getText();
        String bigNum1 = big.getText();
        String postNum1 = post.getText();

        System.err.println("Full Price for " + currency + " Is: " + preNum1.concat(bigNum1).concat(postNum1));
    }


}
