package com.booking.certificacion.stepdefinitions;

import com.booking.certificacion.exceptions.FailedValidation;
import com.booking.certificacion.models.ReservationData;
import com.booking.certificacion.questions.ValidateMessage;
import com.booking.certificacion.questions.ValidatePriceList;
import com.booking.certificacion.questions.ValidateTheNumberOfStars;
import com.booking.certificacion.tasks.BookHotel;
import com.booking.certificacion.tasks.EnterReservationData;
import com.booking.certificacion.tasks.SelectPriceFilter;
import com.booking.certificacion.tasks.SelectStarsFilter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static com.booking.certificacion.userinterfaces.BookPage.PRICE_BOOK;
import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.PRICE_FILTER;
import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.PRICE_RESULT_HOTELS_LIST;
import static com.booking.certificacion.utils.Messages.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BookHotelStepDefinitions {

    @Given("^the user enters the reservation data$")
    public void theUserEntersTheReservationData(List<ReservationData> reservationData) {
        OnStage.theActorInTheSpotlight().wasAbleTo(EnterReservationData.inBookingPage(reservationData.get(0)));
    }

    @When("^the user reserves the hotel (.*)$")
    public void theUserReservesTheHotel(String hotel) {
        OnStage.theActorInTheSpotlight().attemptsTo(BookHotel.inBookingPage(hotel));
    }

    @When("^the user select the price filter COP 0 - COP 225,000 for Book hotel$")
    public void theUserSelectThePriceFilterCOPCOP() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectPriceFilter.inBookingPage(PRICE_FILTER));
    }

    @When("^the user select the stars filter (.*)$")
    public void theUserSelectTheStarsFilterStars(String filterStars) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectStarsFilter.forHotels(filterStars));
    }

    @Then("^the user will see the price (.*) of the reservation$")
    public void theUserWillSeeThePriceOfTheReservation(String price) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateMessage.ofTheWebElement(PRICE_BOOK), is(equalTo(price)))
                .orComplainWith(FailedValidation.class, WRONG_BOOKING_PRICE.getMsg()));
    }

    @Then("^the user will see hotels with prices less than (\\d+)$")
    public void theUserWillSeeHotelsWithPricesLessThan(int price) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidatePriceList.forFilter(PRICE_RESULT_HOTELS_LIST, price))
                .orComplainWith(FailedValidation.class, PRICE_FILTER_FAILED.getMsg()));
    }

    @Then("^the user will see hotels with (\\d+) stars$")
    public void theUserWillSeeHotelsWithStars(int stars) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheNumberOfStars.ofTheHotels(stars))
                .orComplainWith(FailedValidation.class, STARS_FILTER_FAILED.getMsg()));
    }
}
