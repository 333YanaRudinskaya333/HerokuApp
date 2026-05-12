import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class DynamicControls extends BaseTest {

    @Test
    public void checkDynamicControlsRemeve() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[type='checkbox']")));
        int numberOfElements = driver.findElements(By.cssSelector("[type='checkbox']")).size();
        assertEquals(numberOfElements, 0);
    }

    @Test
    public void isFieldDisabled() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));
        assertFalse(inputField.isEnabled());
    }

    @Test
    public void isFieldEnabled() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        WebElement enabledInputField = driver.findElement(By.cssSelector("input[type='text']"));
        assertTrue(enabledInputField.isEnabled());
    }
}
