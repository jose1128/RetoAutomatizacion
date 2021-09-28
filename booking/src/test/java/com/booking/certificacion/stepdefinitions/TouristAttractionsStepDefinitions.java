package com.booking.certificacion.stepdefinitions;

import com.booking.certificacion.exceptions.FailedValidation;
import com.booking.certificacion.models.AttractionData;
import com.booking.certificacion.questions.ValidateMessage;
import com.booking.certificacion.questions.ValidatePriceList;
import com.booking.certificacion.tasks.NavigateTo;
import com.booking.certificacion.tasks.ReserveAttraction;
import com.booking.certificacion.tasks.SearchDestiny;
import com.booking.certificacion.tasks.SelectPriceFilter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static com.booking.certificacion.userinterfaces.AttractionDetailsPage.TOTAL_PRICE;
import static com.booking.certificacion.userinterfaces.AttractionsPage.FILTER_PRICE;
import static com.booking.certificacion.userinterfaces.AttractionsPage.PRICE_FILTER_RESULTS;
import static com.booking.certificacion.utils.Messages.PRICE_FILTER_FAILED;
import static com.booking.certificacion.utils.Messages.WRONG_ATTRACTION_PRICE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TouristAttractionsStepDefinitions {

    @Given("^the user navigate to (.*)$")
    public void theUserNavigateToRegister(String option) {
        OnStage.theActorInTheSpotlight().wasAbleTo(NavigateTo.optionOfThePage(option));
    }

    @When("^the user reserves the attraction$")
    public void theUserReservesTheAttraction(List<AttractionData> attractionData) {
        OnStage.theActorInTheSpotlight().attemptsTo(ReserveAttraction.inBookingPage(attractionData.get(0)));
    }

    @When("^the user select the price filter COP 0 - COP 90.080 for tourist attractions$")
    public void theUserSelectThePriceFilterCOPCOPForTouristAttractions() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectPriceFilter.inBookingPage(FILTER_PRICE));
    }

    @And("^the user search the attraction in (.*)$")
    public void theUserSearchTheAttractionTour(String destiny) {
        OnStage.theActorInTheSpotlight().wasAbleTo(SearchDestiny.ofAttraction(destiny));
    }

    @Then("^the user will see the total price is (.*)$")
    public void theUserWillSeeTheTotalPriceOfAdultsAndKids(String totalPrice) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateMessage.ofTheWebElement(TOTAL_PRICE), is(equalTo(totalPrice)))
                .orComplainWith(FailedValidation.class, WRONG_ATTRACTION_PRICE.getMsg()));
    }

    @Then("^the user will see tourist attractions with prices less than (\\d+)$")
    public void theUserWillSeeTouristAttractionsWithPricesLessThan(int price) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidatePriceList.forFilter(PRICE_FILTER_RESULTS, price))
                .orComplainWith(FailedValidation.class, PRICE_FILTER_FAILED.getMsg()));
    }
}
