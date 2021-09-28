package com.booking.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateMessage implements Question<String> {
    private Target webElement;

    public ValidateMessage(Target webElement) {
        this.webElement = webElement;
    }

    @Override
    public String answeredBy(Actor actor) {
        return webElement.resolveFor(actor).getText().trim();
    }

    public static ValidateMessage ofTheWebElement(Target webElement) {
        return new ValidateMessage(webElement);
    }
}
