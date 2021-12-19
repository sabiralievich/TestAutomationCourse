import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson6.MainPage;

import java.time.Duration;
import java.util.List;

public class AvitoTest {
    WebDriver driver;
    final String baseURL = "https://www.avito.ru";
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(baseURL);
    }

    @Test
    void likeRandomPost() {
        mainPage.fillSearchBar("шкаф")
                .clickSubmitButton()
                .clickSubmitButton();
        Assertions.assertEquals("active", mainPage.addToFavorites().getAttribute("data-state"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
