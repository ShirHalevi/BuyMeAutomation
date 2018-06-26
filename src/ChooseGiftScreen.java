import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ChooseGiftScreen
{
    List<WebElement> buisness= new ArrayList<WebElement>();
    List<WebElement> chosenMeal= new ArrayList<WebElement>();
    public void CheckURLAfterSearch(WebDriver driver) throws InterruptedException {
        //Assert the URL path
        Thread.sleep(5000);
        Assert.assertEquals(Constans.ExpectedUrAfterSearch,driver.getCurrentUrl());
    }
    public void ClickOnGreg(WebDriver driver) throws InterruptedException {
        //in the result screen press on greg
        Thread.sleep(7000);
        buisness= driver.findElements(By.className("promo-item"));
        buisness.get(Constans.ClickOnGregIndexOne).click();
        Thread.sleep(3000);
    }
  /* Extras
   public void scrollToButtomScreen(WebDriver driver)
    {// scroll to the buttom of the screen - extras
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    } */
    public void ClickOnMeal(WebDriver driver) throws InterruptedException {
        //click on specific greg meal
        Thread.sleep(5000);
        chosenMeal=driver.findElements(By.className("btn-purchase"));
        Thread.sleep(3000);
        chosenMeal.get(Constans.ClickOnGregIndexTwo).click();
        Thread.sleep(4000);
    }

}
