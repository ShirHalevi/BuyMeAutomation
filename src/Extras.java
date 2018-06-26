import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Extras
{
    private static WebDriver driver=null;
    private static String WebURL="";
    public static String getData(String keyName)throws Exception{
        File fXmlFile = new File("C:\\Users\\shir halevi\\Desktop\\qaexpert\\buyMe\\BrowserAndUrl.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
    @BeforeClass
    public static void BeforeBlass() throws Exception
    {// before class
        String browserType = getData("browserType");
        if (browserType.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\shir halevi\\Desktop\\qaexpert\\drivers\\chromedriver.exe");
            driver=new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
        } else if (browserType.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\shir halevi\\Desktop\\qaexpert\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browserType.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\shir halevi\\Desktop\\qaexpert\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else
        {
            //break;
        }
        driver.manage().window().maximize();
        WebURL = getData("WebsiteURL");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void printLoadingIconSize() throws InterruptedException {
        // this test will print the loading icon size
          driver.get(WebURL);
          Thread.sleep(2000);
          driver.navigate().refresh();
        driver.navigate().refresh();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE);
        System.out.println("Loading icon height is :"+driver.findElement(By.className("spinner")).getSize().height);
        System.out.println("Loading icon width is :"+driver.findElement(By.className("spinner")).getSize().width);
      }

@Test
    public void mailAndPassMissing() throws InterruptedException {
        //this test will assert the red validation messages of registration
        driver.get(WebURL);
        Thread.sleep(2000);
    driver.findElement(By.xpath("//span[@class='seperator-link']")).click();
    driver.findElement(By.className("btn-theme")).click();
    Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה",driver.findElement(By.className("parsley-required")).getText());
    }

   // Test 3 is in the Main - chooseGiftScreen.scrollToButtomScreen(driver);// Exras
}
