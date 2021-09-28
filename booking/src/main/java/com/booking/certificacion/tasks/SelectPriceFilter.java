package com.booking.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.RESULTS_TABLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectPriceFilter implements Task {

    private Target filter;

    public SelectPriceFilter(Target filter) {
        this.filter = filter;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(filter),
                WaitUntil.the(RESULTS_TABLE, isVisible())
        );
    }

    public static SelectPriceFilter inBookingPage(Target filter) {
        return Tasks.instrumented(SelectPriceFilter.class, filter);
    }
}
