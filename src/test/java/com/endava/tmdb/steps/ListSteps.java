package com.endava.tmdb.steps;

import com.endava.tmdb.builders.ListBuilder;
import com.endava.tmdb.controllers.ListController;
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

public class ListSteps {

    private com.endava.tmdb.entities.List list;
    private Response response;
    private ListController listController = new ListController();

    @Given("^User has list basic data$")
    public void userHasListBasicData(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        String name = data.get(0).get("name");
        String description = data.get(0).get("description");
        String language = data.get(0).get("language");
        list = new ListBuilder()
                .withName(name)
                .withDescription(description)
                .withLanguage(language)
                .build();
    }

    @When("^The user sends a request to create list$")
    public void theUserSendsARequestToCreateList() {
        response = listController.post(list,"create");
        Serenity.setSessionVariable("response").to(response);
    }

    @And("^The response body contains a status_code \"([^\"]*)\"$")
    public void theResponseBodyContainsAStatus_code(String status_code) throws Throwable {
        Assert.assertThat(String.format("Error: The status code is not %s", status_code),
                response.jsonPath().get("status_code"), Matchers.equalTo(Integer.parseInt(status_code)));
    }

    @And("^The response body contains a list id$")
    public void theResponseBodyContainsAListId() {
        int list_id = response.jsonPath().get("list_id");
        Assert.assertThat(String.format("Error: Response does not contain list_id"),
                list_id, Matchers.notNullValue());
        Serenity.setSessionVariable("list_id").to(list_id);
    }

    @When("^The user sends a request to get a list$")
    public void theUserSendsARequestToGetAList() {
        response = listController.get(list.getList_id());
        Serenity.setSessionVariable("response").to(response);
    }

    @And("^The response body contains name$")
    public void theResponseBodyContainsName() {
        Assert.assertThat("Error response does not contain name",
                response.jsonPath().get("name"), Matchers.notNullValue());
    }

    @And("^The response body contains description$")
    public void theResponseBodyContainsDescription() {
        Assert.assertThat("Error response does not contain name",
                response.jsonPath().get("description"), Matchers.notNullValue());
    }

    @Given("^A list exists with$")
    public void aListExistsWith(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        int list_id = Integer.parseInt(data.get(0).get("list_id"));
        list = new ListBuilder()
               .withListId(list_id)
               .build();
    }
}
