package com.booking.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target PAGE_OPTION = Target.the("{0}").locatedBy("(//*[contains(text(), '{0}')])[1]");
    public static final Target DESTINATION_FIELD = Target.the("Destination field").located(By.id("ss"));
    public static final Target CHECKIN_CHECHOUT_FIELD = Target.the("Check-in and check-out date field").locatedBy("//div[@data-mode='checkin']");
    public static final Target CHECKIN_CHECKOUT_CALENDAR = Target.the("Check-in and check-out calendar").locatedBy("//td[@data-date = '{0}']");
    public static final Target SEARCH_DESTINATION_BUTTON = Target.the("Search destination button").locatedBy("//span[contains(text(), 'Buscar')]");


    private HomePage() {
    }
}
