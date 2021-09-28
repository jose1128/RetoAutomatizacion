package com.booking.certificacion.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static com.booking.certificacion.userinterfaces.AttractionsPage.SEARCH_ATTRACTION_FIELD;
import static org.openqa.selenium.Keys.ENTER;

public class SearchDestiny implements Task {

    private String destiny;

    public SearchDestiny(String destiny) {
        this.destiny = destiny;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Enter.theValue(destiny).into(SEARCH_ATTRACTION_FIELD),
                Enter.keyValues(ENTER).into(SEARCH_ATTRACTION_FIELD)
        );
    }

    public static SearchDestiny ofAttraction(String destiny) {
        return Instrumented.instanceOf(SearchDestiny.class).withProperties(destiny);
    }
}
