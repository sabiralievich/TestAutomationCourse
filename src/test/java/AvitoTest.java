import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    void likeRandomPost() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@data-marker='search-form/suggest']")).sendKeys("шкаф");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@data-marker='search-form/submit-button']")).click();
        Thread.sleep(3000);
        List<WebElement> postList =
                driver.findElements(By.xpath("//a[contains(translate(@title, 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ', " +
                        "'абвгдежзийклмнопрстуфхцчшщъыьэюя '), 'шкаф')]/ancestor::div[contains(@class, " +
                        "'iva-item-titleStep')]/preceding-sibling::div/descendant::div[@data-marker='favorites-add']"));
        Thread.sleep(3000);
                WebElement testedPost = postList.stream().findAny().get();
                testedPost.click();
                Thread.sleep(3000);
                Assertions.assertTrue(testedPost.getAttribute("data-state").equals("active"));

        // Поиск карточек объявлений со словом Шкаф в названии?
        // //a[contains(translate(@title, 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ', 'абвгдежзийклмнопрстуфхцчшщъыьэюя '), 'шкаф')]/ancestor::div[contains(@class, 'iva-item-titleStep')]/preceding-sibling::div/child::span
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
