package com.booking.certificacion.tasks;

import com.booking.certificacion.interactions.SwitchTo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.*;

public class BookHotel implements Task {

    private String hotel;

    public BookHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HOTELS_DETINATION_RESULTS.of(hotel)),
                SwitchTo.window(),
                Click.on(RESERVE_NOW_HOTEL_BUTTON),
                Click.on(RESERVE_HOTEL_BUTTON)
        );
    }

    public static BookHotel inBookingPage(String hotel) {
        return Instrumented.instanceOf(BookHotel.class).withProperties(hotel);
    }
}
