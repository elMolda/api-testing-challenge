package com.endava.tmdb.steps;

import com.endava.tmdb.builders.RateBuilder;
import com.endava.tmdb.controllers.RateController;
import com.endava.tmdb.entities.Rate;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RatingSteps {
    private Response response;
    private Rate rate;
    private RateController rateController = new RateController();


    @Given("^User has movie id and a value$")
    public void userHasMovieIdAndAValue(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        String movie_id = data.get(0).get("movie_id");
        int value = Integer.parseInt(data.get(0).get("value"));
        rate = new RateBuilder()
                .withMovieId(movie_id)
                .withValue(value)
                .build();
    }

    @When("^User sends request to rate a movie$")
    public void userSendsRequestToRateAMovie() {
        response = rateController.post(rate,"movie");
        Serenity.setSessionVariable("response").to(response);
    }

    @And("^The response body contains a status_code$")
    public void theResponseBodyContainsAStatus_code() {
        response = Serenity.sessionVariableCalled("response");
        Integer[] validCodes = {1,12};
        Assert.assertThat("Invalid status code", response.jsonPath().get("status_code"),
                Matchers.isOneOf(validCodes));
    }
}
