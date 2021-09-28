package com.booking.certificacion.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.PRICE_RESULT_HOTELS_LIST;
import static com.booking.certificacion.utils.Conversions.*;
import static com.booking.certificacion.utils.Resources.CHARACTER_POINT;
import static com.booking.certificacion.utils.Resources.COP;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class CompareList {

    private CompareList() {
    }


    public static Boolean toValidateRanges(List<WebElementFacade> prices, int price) {
        int priceCounter = (int) prices.stream().filter(priceResult -> {
            String result = replaceCharacters(priceResult.getText(), EMPTY, COP.getResource(), CHARACTER_POINT.getResource());
            return stringToInt(result) <= price;
        }).count();
        return prices.size() == priceCounter;
    }


    public static boolean starsOfTheHotels(Target target, Actor actor, int stars) {
        for (int i = 1; i <= PRICE_RESULT_HOTELS_LIST.resolveAllFor(actor).size(); i++) {
            if (target.of(intToString(i)).resolveAllFor(actor).size() != stars)
                return false;
        }
        return true;
    }
}
