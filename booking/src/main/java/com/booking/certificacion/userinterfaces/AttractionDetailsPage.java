package com.booking.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AttractionDetailsPage {

    public static final Target SELECT_ATTRACTION = Target.the("Select attrataction").locatedBy("(//button[@data-testid])[2]");
    public static final Target SELECT_ADULTS_AND_KIDS = Target.the("Select adults and kids").locatedBy("(//button[@data-testid = 'add-ticket'])[{0}]");
    public static final Target NEXT_RESERVE_ATTRACTION_BUTTON = Target.the("Continue reserve attractions").locatedBy("//span[text() = 'Siguiente']");
    public static final Target TOTAL_PRICE = Target.the("Total price").locatedBy("(//div[@class = 'Text-module__root--variant-strong_1___2aniL'])[6]");

    private AttractionDetailsPage() {
    }

}
