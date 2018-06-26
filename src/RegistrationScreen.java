import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationScreen
{
    public static WebElement element=null;
    public void goToBuyMeWebSite(WebDriver driver,String WebURL) throws InterruptedException {
        //go To Buy Me WebSite
        Thread.sleep(10000);
        driver.get(WebURL);
    }

   public void pressOnRegister(WebDriver driver) throws InterruptedException {
        //press On Register button
       Thread.sleep(2000);
       driver.findElement(By.xpath("//span[@class='seperator-link']")).click();
   }

    public void haveRegisterYetLink(WebDriver driver)
    {//click on have Register Yet Link
        driver.findElement(By.className("header-link")).click();
    }

    public void enterDetailsToRegister (WebDriver driver)
    {//enter Details To Register
        driver.findElement(By.id("ember858")).sendKeys(Constans.userName);
        driver.findElement(By.id("ember859")).sendKeys(Constans.mail);
        driver.findElement(By.id("valPass")).sendKeys(Constans.password);
        driver.findElement(By.id("ember861")).sendKeys(Constans.password);
        driver.findElement(By.xpath("//label[@for='register-consent']")).click();
    }
    public void pressOnRegisterToBuyMe (WebDriver driver)
    {//press On Register To BuyMe button
        driver.findElement(By.className("btn-theme")).click();
    }
}
