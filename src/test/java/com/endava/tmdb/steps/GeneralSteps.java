package com.endava.tmdb.steps;

import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class GeneralSteps {
    private Response response;

    @Then("^The service responds with a status code \"([^\"]*)\"$")
    public void theServiceRespondsWithAStatusCode(String statusCode) throws Throwable {
        response = Serenity.sessionVariableCalled("response");
        Assert.assertThat(response.prettyPrint(),
                response.statusCode(), Matchers.equalTo(Integer.parseInt(statusCode)));
    }
}
