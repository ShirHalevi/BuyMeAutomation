import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING)
public class Main
{
    private static WebDriver driver=null;
    private static String WebURL="";
    private static  RegistrationScreen registrationScreen=new RegistrationScreen();
    private static  HomeScreen homeScreen= new HomeScreen();
    private static  ChooseGiftScreen chooseGiftScreen= new ChooseGiftScreen();
    private static  ReciverDetailesScreen reciverDetailesScreen= new ReciverDetailesScreen();

    @Rule
    public TestName name = new TestName();
    private static ExtentReports extent ;
    private static ExtentTest test ;

    @BeforeClass
    public static void BeforeBlass() throws Exception
    {
        setReport();
        boolean driverEstablish = false;
        try {
            String browserType = BrowserAndURL.getData("browserType");
            if (browserType.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\shir halevi\\Desktop\\qaexpert\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
            } else if (browserType.equals("IE")) {
                System.setProperty("webdriver.ie.driver", "C:\\Users\\shir halevi\\Desktop\\qaexpert\\drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (browserType.equals("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\shir halevi\\Desktop\\qaexpert\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                //break;
            }
            driver.manage().window().maximize();
            WebURL = BrowserAndURL.getData("WebsiteURL");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        catch (Exception e)
        {
             e.printStackTrace();
            Assert.fail("Cant connect to driver");
            test.log(Status.FATAL,
            "Driver Connection Failed! " + e.getMessage());
             driverEstablish = false;
            } finally
              {
                if (driverEstablish)
                {
                  test.log(Status.PASS, "Driver established successfully");
                }
              }
}

    boolean reachToBuyMeWorks=false;
    @Test
    public void Test1_ReachToBuyMe() throws InterruptedException, IOException {

        try {
            registrationScreen.goToBuyMeWebSite(driver, WebURL);
            reachToBuyMeWorks=true;
        }
        catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Reach to BuyMe process failed" + e.getMessage());
           reachToBuyMeWorks = false;
        } finally

        {
            if (reachToBuyMeWorks) {
                test.log(Status.PASS, "Reach to BuyMe Done successfully");
            }
        }
        //screenshot on home screen
        test.pass("Home Screen Before Registration", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath+ "1.Home Screen Before Registration")).build());
    }

    boolean RegisterToBuyMeWorks=false;
    @Test
    public void Test2_RegisterToBuyMe() throws InterruptedException, IOException {
        try {
            registrationScreen.pressOnRegister(driver);
            //screenshot on register screen
            test.pass("Sign in/Register screen display", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "2.sign in or register screen")).build());
            registrationScreen.haveRegisterYetLink(driver);
            registrationScreen.enterDetailsToRegister(driver);
            //screenshot on register screen
            test.pass("Register screen -details entered", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "3.Registration Page Details Entered")).build());
            registrationScreen.pressOnRegisterToBuyMe(driver);
            RegisterToBuyMeWorks = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Registration to BuyMe failed" + e.getMessage());
            RegisterToBuyMeWorks = false;
        } finally {
            if (RegisterToBuyMeWorks) {
                test.log(Status.PASS, "Registration Done successfully");
            }
        }
       }

    boolean SearchButtonWorks=false;
    @Test
    public void Test3_SearchForGift() throws InterruptedException, IOException {
        try {
            homeScreen.choosePrice(driver);
            homeScreen.chooseArea(driver);
            homeScreen.chooseCategory(driver);
            //screenshot of all fields entered
            test.pass("Home Screen After registration with fields entered to search for a gift", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "4.Home Screen After registration with fields entered to search for a gift")).build());
            homeScreen.pressOnSearchGift(driver);
            //screenshot on the search results
            test.pass("Search Result", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "5.Search Result screen")).build());
            SearchButtonWorks=true;
        }catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Searching for a gift failed" + e.getMessage());
            SearchButtonWorks = false;
        } finally
        {
            if (SearchButtonWorks) {
                test.log(Status.PASS, "Searching for a gift Done successfully");
            }
        }

    }

    boolean clickOnMealworks=false;
    @Test
    public void Test4_ChooseBuiesnessAndCheckURL() throws InterruptedException {
try
     {
       chooseGiftScreen.CheckURLAfterSearch(driver);
        // chooseGiftScreen.scrollToButtomScreen(driver);// Extras
       chooseGiftScreen.ClickOnGreg(driver);
         //screenshot on the greg screen
         test.pass("GregScreen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "6.Greg screen")).build());
         chooseGiftScreen.ClickOnMeal(driver);
         clickOnMealworks=true;
     }
     catch (Exception e)
     {
    e.printStackTrace();
    test.log(Status.FAIL, "click on specific meal failed " + e.getMessage());
         clickOnMealworks = false;
     }
     finally
         {
          if (clickOnMealworks)
             {
              test.log(Status.PASS, "click on specific meal works");
             }
          }
    }
    boolean clickOnSubmitGiftworks=false;
    @Test
    public  void  Test5_SenderAndReceiverInformation() throws InterruptedException, IOException {
        try {
            //screenshot on the receiver and sender details
            test.pass("Reciver details screen- before filled", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "7.Sender and reciever Details screen")).build());
            //reciverDetailesScreen.whoToSendToAssert(driver);
            reciverDetailesScreen.clickOnSomeoneElseButton(driver);
            reciverDetailesScreen.enterReciverName(driver);
            reciverDetailesScreen.enterSenderName(driver);
            reciverDetailesScreen.enterBlessing(driver);
            reciverDetailesScreen.uploadImage(driver);
            reciverDetailesScreen.pickEvent(driver);
            reciverDetailesScreen.chooseSendNowRadioBtn(driver);
            reciverDetailesScreen.chooseEmailOfReciver(driver);
            reciverDetailesScreen.enterEmailOfReciverAndSave(driver);
            //screenshot on the receiver and sender details- filled
            test.pass("Receiver and sender details screen- filled", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "8.Sender and reciever Details screen fields were filled")).build());
            reciverDetailesScreen.submitGift(driver);
            //screenshot on the payment screen
            Thread.sleep(5000);
            test.pass("payment screen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.screenshotPath + "9.payment screen")).build());
            clickOnSubmitGiftworks=true;
        }catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "click on submit Gift failed" + e.getMessage());
            clickOnSubmitGiftworks = false;
        } finally
        {
            if(clickOnSubmitGiftworks)
                test.log(Status.PASS, "click on submitGift works");
            }

    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test "
                + "After test method");
        driver.quit();

        // build and flush report
        extent.flush();
    }

    private static String takeScreenShot(String ImagesPath) {
      //take a screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
    public static void setReport()
    { // create html reporter and set its settings
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("\\C:\\Users\\shir halevi\\Desktop\\qaexpert\\buyMe\\reports\\extent.html");
        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMeSanityTestWeb", "This is a BuyMe Sanity Test Web");
        extent.setSystemInfo("Tester", "Shir");
        test.log(Status.INFO, "@Before class");
    }
}




