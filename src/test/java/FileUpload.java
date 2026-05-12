import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FileUpload extends BaseTest {

    @Test
    public void checkFileUpload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/java/1.csv");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        String uploadedFile = driver.findElement(By.id("uploaded-files")).getText();
        wait.until(ExpectedConditions.textToBe(By.id("uploaded-files"), "1.csv"));
        assertEquals(uploadedFile, "1.csv", "FileName isn't  match");
    }
}
