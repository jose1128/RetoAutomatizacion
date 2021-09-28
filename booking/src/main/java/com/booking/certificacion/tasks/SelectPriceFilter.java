package com.booking.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectPriceFilter implements Task {

    private Target filter;

    public SelectPriceFilter(Target filter) {
        this.filter = filter;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(filter, isVisible()),
                Click.on(filter)
        );
    }

    public static SelectPriceFilter inBookingPage(Target filter) {
        return Tasks.instrumented(SelectPriceFilter.class, filter);
    }
}
