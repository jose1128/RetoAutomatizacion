package com.booking.certificacion.questions;

import com.booking.certificacion.utils.CompareList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.booking.certificacion.userinterfaces.ResultSearchDestinationPage.HOTEL_STARS;

public class ValidateTheNumberOfStars implements Question<Boolean> {

    private int stars;

    public ValidateTheNumberOfStars(int stars) {
        this.stars = stars;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CompareList.starsOfTheHotels(HOTEL_STARS, actor, stars);
    }

    public static ValidateTheNumberOfStars ofTheHotels(int stars) {
        return new ValidateTheNumberOfStars(stars);
    }
}
