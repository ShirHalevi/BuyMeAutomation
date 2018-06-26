import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class ReciverDetailesScreen
{
    List<WebElement> radioButtons= new ArrayList<WebElement>();
    List<WebElement> ChosenSingleList= new ArrayList<WebElement>();
    List<WebElement> activeResultList= new ArrayList<WebElement>();
    List<WebElement> btnThemeList= new ArrayList<WebElement>();

    public void clickOnSomeoneElseButton(WebDriver driver) throws InterruptedException
    {//click On Someone Else radio Button
        Thread.sleep(10000);
        radioButtons= driver.findElements(By.className("circle-wrapper"));
        radioButtons.get(Constans.clickOnSomeoneElseButtonIndex).click();
    }

  /*  public void whoToSendToAssert(WebDriver driver)
    {
        List<WebElement> whoToSendToClass= new ArrayList<WebElement>();
        whoToSendToClass= driver.findElements(By.className("item-summary"));
        Assert.assertEquals("#f7b336",whoToSendToClass.get(0).getCssValue("color"));
    } */
    public void enterReciverName(WebDriver driver) {
        //enter reciver name
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("reciver-name")));
        actions.click();
        actions.sendKeys(Constans.ReciverName);
        actions.build().perform();
    }
    public void enterSenderName(WebDriver driver)
    {//enterSenderName
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("sender-name")));
        actions.click();
        actions.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        actions.sendKeys(Keys.DELETE);
        actions.sendKeys(Constans.SenderName);
        actions.build().perform();
    }
    public void enterBlessing(WebDriver driver)
    {//enterBlessing to reciver
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("msg")));
        actions.click();
        actions.sendKeys(Constans.BlessingContent);
        actions.build().perform();
    }
    public void uploadImage(WebDriver driver)
    {// uploading image
        driver.findElement(By.className("file-upload-input")).sendKeys(Constans.uploadImagePath);
    }
    public void pickEvent(WebDriver driver)
    {// choose event from list
        ChosenSingleList = driver.findElements(By.className("chosen-single"));
        ChosenSingleList.get(Constans.pickEventIndexOne).click();
        activeResultList = driver.findElements(By.className("active-result"));
        activeResultList.get(Constans.pickEventIndexTwo).click();
    }
    public void chooseSendNowRadioBtn(WebDriver driver)
    {// click on send now radio button
        driver.findElement(By.className("send-now")).click();
    }
    public void chooseEmailOfReciver(WebDriver driver)
    { //click on choose Email Of Reciver
        driver.findElement(By.className("icon-envelope")).click();
    }
    public void enterEmailOfReciverAndSave(WebDriver driver) throws InterruptedException
    {//enter Email Of Reciver And Save
        Thread.sleep(5000);
        driver.findElement(By.className("input-mail")).sendKeys(Constans.ReciverMail);
        driver.findElement(By.className("btn-save")).click();
    }
    public void submitGift(WebDriver driver)
    {//click on submit gift button
        WebDriverWait waiter = new WebDriverWait(driver, 15000);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("send-options-details-email"))));
        driver.findElement(By.className("submit-wrapper")).click();
    }
}
