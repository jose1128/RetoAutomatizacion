package com.booking.certificacion.tasks;

import com.booking.certificacion.interactions.SwitchTo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BookHotel implements Task {

    private String hotel;

    public BookHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HOTELS_DETINATION_RESULTS.of(hotel), isVisible()),
                Click.on(HOTELS_DETINATION_RESULTS.of(hotel)),
                SwitchTo.window(),
                WaitUntil.the(NUMBER_OF_ROOMS, isEnabled()),
                SelectFromOptions.byValue("1").from(NUMBER_OF_ROOMS),
                Click.on(RESERVE_HOTEL_BUTTON)
        );
    }

    public static BookHotel inBookingPage(String hotel) {
        return Instrumented.instanceOf(BookHotel.class).withProperties(hotel);
    }
}
