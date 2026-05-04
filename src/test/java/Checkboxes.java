import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Checkboxes {
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
    public void uncheckedAndCheckedFirstCheckbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        boolean isFirstCheckboxUnchecked = driver.findElements(By.cssSelector("[type='checkbox']")).get(0).isSelected();
        Assert.assertFalse(isFirstCheckboxUnchecked);
        driver.findElements(By.cssSelector("[type='checkbox']")).get(0).click();
        boolean isFirstCheckboxChecked = driver.findElements(By.cssSelector("[type='checkbox']")).get(0).isSelected();
        Assert.assertTrue(isFirstCheckboxChecked);
    }

    @Test
    public void checkedAndUncheckedSecondCheckbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        boolean isSecondCheckboxChecked = driver.findElements(By.cssSelector("[type='checkbox']")).get(1).isSelected();
        Assert.assertTrue(isSecondCheckboxChecked);
        driver.findElements(By.cssSelector("[type='checkbox']")).get(1).click();
        boolean isSecondCheckboxUnchecked = driver.findElements(By.cssSelector("[type='checkbox']")).get(1).isSelected();
        Assert.assertFalse(isSecondCheckboxUnchecked);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
