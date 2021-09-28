package com.booking.certificacion.tasks;

import com.booking.certificacion.userinterfaces.HomePage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class NavigateTo implements Task {
    private String option;

    public NavigateTo(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(HomePage.PAGE_OPTION.of(option)));
    }

    public static NavigateTo optionOfThePage(String option) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(option);
    }
}
