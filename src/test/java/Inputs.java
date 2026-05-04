import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Inputs {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void digitalValues() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).click();
        driver.findElement(By.tagName("input")).sendKeys("5");
        String valueAfterNumberFive = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(valueAfterNumberFive, "5");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String valueAfterNumberSix = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(valueAfterNumberSix, "6");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String valueAfterNumberFour = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(valueAfterNumberFour, "4");
    }

    @Test
    public void nonNumericValue() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).click();
        driver.findElement(By.tagName("input")).sendKeys("a");
        String valueNonNumeric = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(valueNonNumeric, "", "Поле не должно принимать буквы!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
