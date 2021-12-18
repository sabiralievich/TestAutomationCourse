import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AvitoTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    final String AVITO_BASE_URL = "https://www.avito.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void likeRandomPost() {
        String searchedString = "шкаф";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='search-form/suggest']")));
        driver.findElement(By.xpath("//*[@data-marker='search-form/suggest']")).sendKeys(searchedString);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='search-form/submit-button']")));
        driver.findElement(By.xpath("//*[@data-marker='search-form/submit-button']")).click();
        List<WebElement> postList = driver.findElements(By.xpath("//a[contains(translate(@title, 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ', " + "'абвгдежзийклмнопрстуфхцчшщъыьэюя '), '" + searchedString + "')]/ancestor::div[contains(@class, " + "'iva-item-titleStep')]/preceding-sibling::div/descendant::div[@data-marker='favorites-add']"));
        WebElement testedPost = postList.stream().findAny().get();
        testedPost.click();
        Assertions.assertEquals("active", testedPost.getAttribute("data-state"));
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(AVITO_BASE_URL);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void afterAll() {

    }
}