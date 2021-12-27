import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.lesson8.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {
    @Given("Url https:\\/\\/avito.ru is opened")
    public void urlHttpsAvitoRuIsOpened() {
        open("https://avito.ru");
    }
    @When("I fill the search bar")
    public void iFillTheSearchBar() {
        new MainPage().fillSearchBar("шкаф");
    }

    @And("I click Submit button")
    public void iClickSubmitButton() {
        new MainPage().clickSubmitButton();
    }

    @And("I add random post to favorites")
    public void iAddRandomPostToFavorites() {
        new MainPage().addToFavorites();
    }

    @Then("Heart icon of the post becomes red")
    public void heartIconOfThePostBecomesRed() {
    }

}
