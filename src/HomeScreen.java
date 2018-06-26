import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class HomeScreen
{
     List<WebElement> dropdowns= new ArrayList<WebElement>();
     List<WebElement> dropdownsOptions= new ArrayList<WebElement>();


    public void choosePrice(WebDriver driver) throws InterruptedException {
//click on the list and choose price
        Thread.sleep(10000);
        dropdowns= driver.findElements(By.className("chosen-single"));
        dropdowns.get(Constans.choosePriceDropdownIndex).click();
        dropdownsOptions=driver.findElements(By.className("active-result"));
        dropdownsOptions.get(Constans.choosePriceDropdownOptionsIndex).click();
    }

    public void chooseArea(WebDriver driver)
    {//click on the list and choose area
        dropdowns= driver.findElements(By.className("chosen-single"));
        dropdowns.get(Constans.chooseAreaDropdownIndex).click();
        dropdownsOptions=driver.findElements(By.className("active-result"));
        dropdownsOptions.get(Constans.chooseAreaDropdownOptionsIndex).click();
    }

    public void chooseCategory(WebDriver driver)
    {//click on the list and choose category
        dropdowns= driver.findElements(By.className("chosen-single"));
        dropdowns.get(Constans.chooseCategoryDropdownIndex).click();
        dropdownsOptions=driver.findElements(By.className("active-result"));
        dropdownsOptions.get(Constans.chooseCategoryDropdownOptionsIndex).click();
    }

    public void pressOnSearchGift(WebDriver driver) throws InterruptedException {//submit
        driver.findElement(By.className("hidden-mid-size")).click();
Thread.sleep(5000);
    }
}
