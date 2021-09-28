package com.booking.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BookPage {

    public static final Target PRICE_BOOK = Target.the("Price book").locatedBy("//div[@data-pd-total-usercurrency]");

    private BookPage() {
    }
}
