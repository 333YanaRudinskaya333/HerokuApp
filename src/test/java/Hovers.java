import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Hovers extends BaseTest {

    @Test
    public void checkFileUpload() {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement frirstWebElement = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        action.moveToElement(frirstWebElement).perform();
        WebElement name1 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]"));
        wait.until(ExpectedConditions.visibilityOf(name1));
        softAssert.assertEquals(name1.getText(), "name: user1");
        driver.findElement(By.xpath("(//div[@class='figcaption']//a)[1]")).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Not Found");
        driver.navigate().back();
        WebElement secondWebElement = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        action.moveToElement(secondWebElement).perform();
        WebElement name2 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[2]"));
        wait.until(ExpectedConditions.visibilityOf(name2));
        softAssert.assertEquals(name2.getText(), "name: user2");
        driver.findElement(By.xpath("(//div[@class='figcaption']//a)[2]")).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Not Found");
        driver.navigate().back();
        WebElement thirdWebElement = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
        action.moveToElement(thirdWebElement).perform();
        WebElement name3 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[3]"));
        wait.until(ExpectedConditions.visibilityOf(name3));
        softAssert.assertEquals(name3.getText(), "name: user3");
        driver.findElement(By.xpath("(//div[@class='figcaption']//a)[3]")).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Not Found");
        driver.navigate().back();
        softAssert.assertAll();
    }
}
