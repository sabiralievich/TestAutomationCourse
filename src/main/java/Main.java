import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ToolsQA.webTables(createChromeInstance());
        Uitestingplayground.clientDelay(createChromeInstance());
        Uitestingplayground.click(createChromeInstance());
        Saucedemo.buySomething(createChromeInstance());
    }

    private static WebDriver createChromeInstance() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

}
