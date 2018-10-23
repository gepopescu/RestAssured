package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetRequestStepDefinition {
    private RequestSpecification request;
    private Response response;

    @Given("^I have access to perform GET request$")
    public void iHaveAccessToPerformGETRequest() throws Throwable {
       request = given().baseUri("http://bhdtest.endava.com:8080/petclinic/api").
               contentType(ContentType.JSON);

    }

    @When("^I perform GET request to \"([^\"]*)\"$")
    public void iPerformGETRequestTo(String path) throws Throwable {
        response = request.when().get(path);
    }

    @Then("^I will have status code \"([^\"]*)\"$")
    public void iWillHaveStatusCode(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }

    @Given("^I have access to perform POST request$")
    public void iHaveAccessToPerformPOSTRequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                body("{\"name\": \"AnimalG\"}").
                contentType(ContentType.JSON);
    }

    @When("^I perform a POST to \"([^\"]*)\"$")
    public void iPerformAPOSTTo(String path) throws Throwable {
        response = request.when().post(path);
    }

    @Given("^I have access to perform Put request$")
    public void iHaveAccessToPerformPutRequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                pathParam("petTypeId",180).
                body("{\"name\": \"animalanimalllll\"}").
                contentType(ContentType.JSON);
    }

    @When("^I perform a PUT to \"([^\"]*)\"$")
    public void iPerformAPUTTo(String path) throws Throwable {
        response = request.when().put(path);
    }

    @Given("^I have access to perform Delete request$")
    public void iHaveAccessToPerformDeleteRequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                pathParam("petTypeId",180).
                contentType(ContentType.JSON);
    }

    @When("^I perform a Delete to \"([^\"]*)\"$")
    public void iPerformADeleteTo(String path) throws Throwable {
        response = request.when().delete(path);

    }
}
