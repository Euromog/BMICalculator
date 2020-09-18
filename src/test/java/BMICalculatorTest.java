import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {

    @Test
    public  void checkNormalCategory(){
        //Установить системную переменную для Chrome
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        //Установить системную переменную для Firefox
//        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");


        //открыть браузер Chrome
        WebDriver driver = new ChromeDriver();

        //Открыть браузер Firefox
//        WebDriver driver = new FirefoxDriver();

        //открыть https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");

        //Ввести вес
        WebElement weightInput = driver.findElement(By.name("wg"));
        weightInput.sendKeys("60");


        //Ввести рост
        WebElement heightInput = driver.findElement(By.name("ht"));
        heightInput.sendKeys("170");

        //Нажать кнопку Calculate
        WebElement calculateButton = driver.findElement(By.name("cc"));
        calculateButton.click();

        //Проверить, что категория Normal
        WebElement categoryInput = driver.findElement(By.name("desc"));
        String actualCategory = categoryInput.getAttribute("value");

        assertEquals(actualCategory, "Your category is Normal", "Category should be Normal");


        WebElement siInput = driver.findElement(By.name("si"));
        String actualSi = siInput.getAttribute("value");

        String expectedSi = "20.76";
        assertEquals(actualSi, expectedSi, "Your SI should be " + expectedSi);


        //закрыть браузер
        driver.quit();

        //        //NEW TEST
//        Select selector = new Select(By.cssSelector("select[name=opt1]").findElement(driver));
//        selector.selectByValue("pounds");



    }
}
