import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdatePetType {

    @Test
    public void putPetType(){
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinic/api";
        //RestAssured.basePath = "/pettypes";
        RestAssured.basePath = "/pettypes";

        given().
                contentType(ContentType.JSON).
                pathParam("petTypId",138).
                body("{\"name\": \"animalanimalllll\"}").
                when().
                put("{petTypId}").
                then().
                statusCode(HttpStatus.SC_NO_CONTENT);

    }
}
