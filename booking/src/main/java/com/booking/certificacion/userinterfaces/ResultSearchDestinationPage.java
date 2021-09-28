package com.booking.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultSearchDestinationPage {

    public static final Target HOTELS_DETINATION_RESULTS = Target.the("{0} hotel").locatedBy("//span[contains(text(), '{0}')]");
    public static final Target RESERVE_NOW_HOTEL_BUTTON = Target.the("Reserve now hotel button").locatedBy("//span[contains(text(), 'Reserva tu apartamento')]");
    public static final Target RESERVE_HOTEL_BUTTON = Target.the("Reserve hotel button").locatedBy("//span[contains(text(), 'Reservaré')]");
    public static final Target PRICE_RESULT_HOTELS_LIST = Target.the("Price results hotels").locatedBy("//div[@data-et-click = 'customGoal:NAREFBINEIfBccOHT:2']//div[4]//div//div[@data-popover-content-id]//span[@class = 'prco-valign-middle-helper']");
    public static final Target PRICE_FILTER = Target.the("COP 0 - COP 225.000 filter").locatedBy("//*[@id=\"filter_price\"]/div[3]/a[1]/label/div/span");
    public static final Target HOTEL_STARS = Target.the("Hotels starts").locatedBy("(//div[@data-et-click = 'customGoal:NAREFBINEIfBccOHT:2'])[{0}]//span[@class = 'bui-icon bui-rating__item bui-icon--medium']");
    public static final Target STARS_FILTER = Target.the("Stars filter").locatedBy("//a[@class = 'filterelement js-filter__element ']//span[contains(text(), '{0}')]");
    public static final Target RESULTS_TABLE = Target.the("Results table").located(By.id("search_results_table"));
    public static final Target NUMBER_OF_ROOMS = Target.the("Results table").locatedBy("(//select[@data-component = 'hotel/new-rooms-table/select-rooms'])[1]");

    private ResultSearchDestinationPage() {
    }

}
