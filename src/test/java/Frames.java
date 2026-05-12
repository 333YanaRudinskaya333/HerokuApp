import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Frames extends BaseTest {

    @Test
    public void checkFileUpload() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.cssSelector("a[href='/iframe']")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String textInIFrame = driver.findElement(By.id("tinymce")).getText();
        assertEquals(textInIFrame, "Your content goes here.", "text in IFrame isn't  match");
    }
}
