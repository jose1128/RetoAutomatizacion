package com.booking.certificacion.interactions;

import com.booking.certificacion.models.AttractionData;
import com.booking.certificacion.userinterfaces.AttractionDetailsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import java.util.stream.IntStream;

import static com.booking.certificacion.utils.Conversions.stringToInt;

public class SelectAdultAndKid implements Interaction {

    private AttractionData attractionData;

    public SelectAdultAndKid(AttractionData attractionData) {
        this.attractionData = attractionData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        IntStream.range(0, stringToInt(attractionData.getAdults())).forEach(adult -> actor.attemptsTo(Click.on(AttractionDetailsPage.SELECT_ADULTS_AND_KIDS.of("1"))));
        IntStream.range(0, stringToInt(attractionData.getKids())).forEach(kid -> actor.attemptsTo(Click.on(AttractionDetailsPage.SELECT_ADULTS_AND_KIDS.of("2"))));
    }

    public static SelectAdultAndKid forReserve(AttractionData attractionData) {
        return Instrumented.instanceOf(SelectAdultAndKid.class).withProperties(attractionData);
    }
}
