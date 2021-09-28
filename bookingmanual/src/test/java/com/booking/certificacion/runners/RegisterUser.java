package com.booking.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\register-user.feature",
        glue = "com.booking.certificacion.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class RegisterUser {
}
