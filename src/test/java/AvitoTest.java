import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.gb.lesson6.CustomLogger;
import ru.gb.lesson6.MainPage;

@Story("Шкафы")
public class AvitoTest {
    EventFiringWebDriver eventFiringWebDriver;
//    WebDriver driver;
    final String baseURL = "https://www.avito.ru";
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        eventFiringWebDriver = new EventFiringWebDriver(new ChromeDriver());
//        driver = new ChromeDriver();
        eventFiringWebDriver.register(new CustomLogger());
        mainPage = new MainPage(eventFiringWebDriver);
        eventFiringWebDriver.get(baseURL);
    }

    @Test
    @Description("Add Post to Favorites")
    @TmsLink(("11"))
    @Feature("Favorites")
    void likeRandomPost() throws InterruptedException {
        mainPage.fillSearchBar("шкаф")
                .clickSubmitButton()
                .clickSubmitButton();
        Thread.sleep(2000);
        Assertions.assertEquals("active", mainPage.addToFavorites().getAttribute("data-state"));
    }

    @AfterEach
    void tearDown() {
        eventFiringWebDriver.quit();
    }

}
