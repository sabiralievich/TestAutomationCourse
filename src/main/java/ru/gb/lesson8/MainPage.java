package ru.gb.lesson8;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private String searchedString = "шкаф";

    SelenideElement searchBar = $(By.xpath("//*[@data-marker='search-form/suggest']"));

    SelenideElement submitButton = $(By.xpath("//*[@data-marker='search-form/submit-button']"));

    private ElementsCollection postList = $$(By.xpath("//a[contains(translate(@title, 'АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ', "
            + "'абвгдежзийклмнопрстуфхцчшщъыьэюя '), 'шкаф')]/ancestor::div[contains(@class, "
            + "'iva-item-titleStep')]/preceding-sibling::div/descendant::div[@data-marker='favorites-add']"));

    //    @Step("Fill the search bar with string value")
    public MainPage fillSearchBar(String searchedString) {
 //     webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='search-form/suggest']")));
        searchBar.sendKeys(searchedString);
        return this;
    }

    //    @Step("Click on Submit button to initiate search")
    public MainPage clickSubmitButton() {
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-marker='search-form/submit-button']")));
        submitButton.click();
        return this;
    }

    //    @Step("Add a post to favorites")
    public WebElement addToFavorites() {
        WebElement testedPost = postList.stream().findAny().get();
        testedPost.click();

        return testedPost;
    }

    public void heartIconOfThePostBecomesRed(){
        Assertions.assertEquals("active", this.addToFavorites().getAttribute("data-state"));

    }
}
