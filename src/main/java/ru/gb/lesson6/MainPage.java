package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BaseView {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private String searchedString = "шкаф";
    @FindBy(xpath = "//*[@data-marker='search-form/suggest']")
    WebElement searchBar;

    @FindBy(xpath = "//*[@data-marker='search-form/submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(translate(@title, 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ', "
            + "'абвгдежзийклмнопрстуфхцчшщъыьэюя '), 'шкаф')]/ancestor::div[contains(@class, "
            + "'iva-item-titleStep')]/preceding-sibling::div/descendant::div[@data-marker='favorites-add']")
    private List<WebElement> postList;

    public MainPage fillSearchBar(String searchedString) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='search-form/suggest']")));
        searchBar.sendKeys(searchedString);
        return this;
    }

    public MainPage clickSubmitButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='search-form/submit-button']")));
        submitButton.click();
        return this;
    }

    public WebElement addToFavorites() {
        WebElement testedPost = postList.stream().findAny().get();
        testedPost.click();
        return testedPost;
    }

}
