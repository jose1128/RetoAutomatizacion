package com.booking.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/tourist-attractions.feature",
        glue = {"com.booking.certificacion.stepdefinitions", "com.booking.certificacion.hooks"},
        snippets = SnippetType.CAMELCASE
)

public class TouristAttractions {
}
