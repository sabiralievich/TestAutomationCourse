import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Uitestingplayground {

    public static void clientDelay(WebDriver driver) throws InterruptedException {
        driver.get("http://uitestingplayground.com/clientdelay");
        Thread.sleep(3000);

        driver.findElement(By.id("ajaxButton")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div//p[text()=\"Data calculated on the client side.\"]"))));
        driver.findElement(By.xpath("//div//p[text()=\"Data calculated on the client side.\"]")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    public static void click(WebDriver driver) throws InterruptedException {

        driver.get("http://uitestingplayground.com/click");
        Thread.sleep(2000);
        driver.findElement(By.id("badButton")).click();
        Thread.sleep(2000);
        driver.quit();
    }


}
