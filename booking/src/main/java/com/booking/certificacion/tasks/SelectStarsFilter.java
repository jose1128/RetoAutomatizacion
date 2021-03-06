package com.booking.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.STARS_FILTER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectStarsFilter implements Task {

    private String filter;

    public SelectStarsFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(STARS_FILTER.of(filter), isVisible()),
                Click.on(STARS_FILTER.of(filter))
        );
    }

    public static SelectStarsFilter forHotels(String filter) {
        return Tasks.instrumented(SelectStarsFilter.class, filter);
    }
}
