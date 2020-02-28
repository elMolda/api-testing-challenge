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
import org.yecht.Data;

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
        double value = Double.parseDouble(data.get(0).get("value"));
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

    @Given("^User has tv id and a value$")
    public void userHasTvIdAndAValue(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        String tv_id = data.get(0).get("tv_id");
        double value = Double.parseDouble(data.get(0).get("value"));
        rate = new RateBuilder()
                .withTvId(tv_id)
                .withValue(value)
                .build();
    }

    @When("^User sends request to rate a tv show$")
    public void userSendsRequestToRateATvShow() {
        response = rateController.post(rate,"tv_show");
        Serenity.setSessionVariable("response").to(response);
    }

    @Given("^User has episode data$")
    public void userHasEpisodeData(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        String tv_id = data.get(0).get("tv_id");
        String episode = data.get(0).get("episode");
        String season = data.get(0).get("season");
        double value = Double.parseDouble(data.get(0).get("value"));
        rate = new RateBuilder()
                .withTvId(tv_id)
                .withEpisode(episode)
                .withSeason(season)
                .withValue(value)
                .build();
    }

    @When("^User sends request to rate an episode$")
    public void userSendsRequestToRateAnEpisode() {
        response = rateController.post(rate,"tv_episode");
        Serenity.setSessionVariable("response").to(response);
    }
}
