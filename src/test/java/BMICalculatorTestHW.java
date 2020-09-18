import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTestHW {
    @Test
    public void checkObuseCategotyWithPounds(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightInput = driver.findElement(By.name("wg"));
        weightInput.sendKeys("60");

        Select selector1 = new Select(By.cssSelector("select[name=opt1]").findElement(driver));
        selector1.selectByValue("pounds");

        Select selector2 = new Select(By.cssSelector("select[name=opt2]").findElement(driver));
        selector2.selectByValue("4");

        Select selector3 = new Select(By.cssSelector("select[name=opt3]").findElement(driver));
        selector3.selectByValue("2");

        WebElement submitButton = driver.findElement(By.name("cc"));
        submitButton.click();

        WebElement categoryInput = driver.findElement(By.name("desc"));
        String actualCategory = categoryInput.getAttribute("value");
        assertEquals(actualCategory, "Your category is Obese", "Category should be Obese");

        driver.quit();

    }
}
