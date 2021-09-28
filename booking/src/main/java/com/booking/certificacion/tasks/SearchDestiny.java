package com.booking.certificacion.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.booking.certificacion.userinterfaces.AttractionsPage.SEARCH_ATTRACTION_FIELD;
import static com.booking.certificacion.userinterfaces.AttractionsPage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchDestiny implements Task {

    private String destiny;

    public SearchDestiny(String destiny) {
        this.destiny = destiny;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                WaitUntil.the(SEARCH_ATTRACTION_FIELD, isEnabled()),
                Enter.theValue(destiny).into(SEARCH_ATTRACTION_FIELD),
                WaitUntil.the(SEARCH_BUTTON, isEnabled()),
                Click.on(SEARCH_BUTTON)
        );
    }

    public static SearchDestiny ofAttraction(String destiny) {
        return Instrumented.instanceOf(SearchDestiny.class).withProperties(destiny);
    }
}
