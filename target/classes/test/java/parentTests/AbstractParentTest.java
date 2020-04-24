package parentTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import pages.ParentPage;

import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected ApparatPage apparatPage;
    protected SparePartsPage spareParts;
    protected String user="Student";
    protected String password="909090";
    protected CoworkersPage coworkers;
    protected Utils utils;
    protected ParentPage parentPage;
    private String pathToScreenShot;


    @Rule
    public TestName testName = new TestName();

    @Before
    public  void SetUp() throws Exception {
        pathToScreenShot = "../avasilyuk/target/screenshot/" + this.getClass().getPackage().getName() + "/" + this.getClass().getSimpleName()
                + this.testName.getMethodName() + ".jpg";

        webDriver = driverInit();

//        try {
//            webDriver = new RemoteWebDriver(
//                    new URL("http://localhost:4444/wd/hub"),
//                    DesiredCapabilities.chrome());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        parentPage = new ParentPage(webDriver);
        apparatPage = new ApparatPage(webDriver);
        spareParts = new SparePartsPage(webDriver);
        coworkers = new CoworkersPage(webDriver);
        utils = new Utils();
    }

    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected  void checkExpectedResult(String message, boolean actualResult) {

        if (!actualResult == true) {
            utils.screenShot(pathToScreenShot, webDriver);
        }
        Assert.assertEquals(message, true, actualResult);
    }
}





