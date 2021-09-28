package com.booking.certificacion.tasks;

import com.booking.certificacion.interactions.SelectAdultAndKid;
import com.booking.certificacion.models.AttractionData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.booking.certificacion.userinterfaces.AttractionDetailsPage.NEXT_RESERVE_ATTRACTION_BUTTON;
import static com.booking.certificacion.userinterfaces.AttractionDetailsPage.SELECT_ATTRACTION;
import static com.booking.certificacion.userinterfaces.AttractionsPage.ATTRACTION_RESULT;
import static com.booking.certificacion.userinterfaces.AttractionsPage.SEARCH_ATTRACTION_FIELD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ReserveAttraction implements Task {

    private AttractionData attractionData;

    public ReserveAttraction(AttractionData attractionData) {
        this.attractionData = attractionData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(attractionData.getDestiny()).into(SEARCH_ATTRACTION_FIELD),
                Enter.keyValues(Keys.ARROW_DOWN).into(SEARCH_ATTRACTION_FIELD),
                Enter.keyValues(Keys.ENTER).into(SEARCH_ATTRACTION_FIELD),
                WaitUntil.the(ATTRACTION_RESULT.of(attractionData.getAttraction()), isVisible()),
                Click.on(ATTRACTION_RESULT.of(attractionData.getAttraction())),
                WaitUntil.the(SELECT_ATTRACTION, isVisible()),
                Click.on(SELECT_ATTRACTION),
                SelectAdultAndKid.forReserve(attractionData),
                Click.on(NEXT_RESERVE_ATTRACTION_BUTTON)
        );
    }

    public static ReserveAttraction inBookingPage(AttractionData attractionData) {
        return Instrumented.instanceOf(ReserveAttraction.class).withProperties(attractionData);
    }
}
