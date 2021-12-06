import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Saucedemo {
    public static void buySomething(WebDriver driver) throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("add-to-cart-sauce-labs-backpack"))));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("Петя");
        driver.findElement(By.id("last-name")).sendKeys("Кантропов");
        driver.findElement(By.id("postal-code")).sendKeys("660099");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
