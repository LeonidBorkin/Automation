package sanity;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlow;

public class TradAirWebAdmin extends CommonOps {

    @Test
    public void tradAirAdminLoginTest(){
        WebFlow.loginTradAir("ayalj@tradair.com", "Panda230");
        WebFlow.VerifyLogo();
    }

   // @Step
    public void tradAirAdminTest(){}



}
