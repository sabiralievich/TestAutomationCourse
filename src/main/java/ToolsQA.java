import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ToolsQA {
    public static void webTables(WebDriver driver) throws InterruptedException {

        driver.get("https://demoqa.com/webtables");
        Thread.sleep(3000);
        driver.findElement(By.id("addNewRecordButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("firstName")).sendKeys("Петя");
        driver.findElement(By.id("lastName")).sendKeys("Кантропов");
        driver.findElement(By.id("userEmail")).sendKeys("ololo@qwerty.com");
        driver.findElement(By.id("age")).sendKeys("18");
        driver.findElement(By.id("salary")).sendKeys("1000");
        driver.findElement(By.id("department")).sendKeys("IT");
        Thread.sleep(3000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}
