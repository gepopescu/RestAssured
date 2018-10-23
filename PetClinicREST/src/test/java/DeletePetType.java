import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePetType {

    @Test
    public void deletePetType(){
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath = "/pettypes/{petTypeId}";

        given().
                pathParam("petTypeId",138).
                when().
                delete().
                then().
                statusCode(HttpStatus.SC_NO_CONTENT);


    }
}
