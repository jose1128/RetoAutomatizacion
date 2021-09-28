package com.booking.certificacion.questions;

import com.booking.certificacion.utils.CompareList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidatePriceList implements Question<Boolean> {

    private Target listPrices;
    private int price;

    public ValidatePriceList(Target listPrices, int price) {
        this.listPrices = listPrices;
        this.price = price;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CompareList.toValidateRanges(listPrices.resolveAllFor(actor), price);
    }

    public static ValidatePriceList forFilter(Target listPrices, int price) {
        return new ValidatePriceList(listPrices, price);
    }
}
