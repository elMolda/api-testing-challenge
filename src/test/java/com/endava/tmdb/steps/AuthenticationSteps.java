package com.endava.tmdb.steps;

import com.endava.tmdb.controllers.AuthController;
import com.endava.tmdb.entities.AuthResponse;
import com.endava.tmdb.helpers.JsonHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AuthenticationSteps {

    private String api_key;
    private AuthController authController = new AuthController();
    private Response response;

    @Given("^User has api key$")
    public void userHasAApiKey(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        api_key = data.get(0).get("api_key");
    }

    @When("^The user sends a request to get a token$")
    public void theUserSendsARequestToGetAToken() {
        response = authController.getWithParam(api_key);
        Serenity.setSessionVariable("response").to(response);
    }

    @And("^The response body contains the request token$")
    public void theResponseBodyContainsTheRequestToken() {
        AuthResponse authResponse = JsonHelper.authResponseBodyToObject(response);
        Assert.assertThat("Error: Body does not contain requestToken",
                authResponse.getRequest_token(), Matchers.notNullValue());
    }

    @When("^User sends request to authorize with$")
    public void userSendsRequestToAuthorizeWith(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");
        response = Serenity.sessionVariableCalled("response");
        AuthResponse authResponse= JsonHelper.authResponseBodyToObject(response);
        authResponse.setPassword(password);
        authResponse.setUsername(username);
        response = authController.post("ask",authResponse,api_key);
        Serenity.setSessionVariable("response").to(response);
    }
}
