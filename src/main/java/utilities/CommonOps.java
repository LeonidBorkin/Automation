package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lpsim.FIXReceiver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;
import quickfix.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else {
            throw new RuntimeException("Invalid Browser Type");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));

        //driver.get(getData("urlDocker"));
        driver.get(getData("URLLocal"));

        ManagePages.initTradAir();

    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        } catch (Exception e) {
            System.out.println("Error Reading XML File: " + e);
        }
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initLPSim() throws ConfigError {
        SessionSettings settings =  new SessionSettings("./Configuration/receiver.cfg");
        myApp = new FIXReceiver();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        ScreenLogFactory screenLogFactory = new ScreenLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        SocketAcceptor acceptor = new SocketAcceptor(myApp, fileStoreFactory,
                settings, screenLogFactory, msgFactory);

        acceptor.start();


        //acceptor.stop();
    }


    @BeforeClass
    public void startSession() throws ConfigError {
        initLPSim();
        //new InitLPThread().start();


        String platform = "web";
        if (platform.equalsIgnoreCase(getData("PlatformName"))){
            initBrowser("chrome");
        }
        /*else if (platform.equalsIgnoreCase("mobile")){
            initMobile();
        }
        else if (platform.equalsIgnoreCase("server")){
            initServer();
        }*/
        else
            throw new RuntimeException("Invalid Platform Name");
    }


    @AfterClass
    public void closeSession(){
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.quit();
    }



}
