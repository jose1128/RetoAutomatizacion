package com.booking.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AttractionsPage {

    public static final Target SEARCH_ATTRACTION_FIELD = Target.the("Search attraction field").locatedBy("//input[@placeholder = 'Destinos, museos, tours...']");
    public static final Target ATTRACTION_RESULT = Target.the("{0}").locatedBy("//h4[text()='{0}']");
    public static final Target FILTER_PRICE = Target.the("Filter price").locatedBy("(//label[@class = 'InputCheckbox-module__container___2Xavj'])[5]");
    public static final Target PRICE_FILTER_RESULTS = Target.the("Price filter results").locatedBy("//div[@class = 'Grid-module__column___2DBft Grid-module__column--size-12___2Eiac']//div[@class = 'css-pori7h']//div[@class = 'Text-module__root--variant-strong_1___2aniL']");

    private AttractionsPage() {
    }
}
