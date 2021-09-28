package com.booking.certificacion.tasks;

import com.booking.certificacion.models.ReservationData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.booking.certificacion.userinterfaces.HomePage.*;

public class EnterReservationData implements Task {

    private ReservationData reservationData;

    public EnterReservationData(ReservationData reservationData) {
        this.reservationData = reservationData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(reservationData.getDestination()).into(DESTINATION_FIELD),
                Click.on(CHECKIN_CHECHOUT_FIELD),
                Click.on(CHECKIN_CHECKOUT_CALENDAR.of(reservationData.getDepartureDate())),
                Click.on(CHECKIN_CHECKOUT_CALENDAR.of(reservationData.getReturnDate())),
                Click.on(SEARCH_DESTINATION_BUTTON)
        );
    }

    public static EnterReservationData inBookingPage(ReservationData reservationData) {
        return Instrumented.instanceOf(EnterReservationData.class).withProperties(reservationData);
    }
}
