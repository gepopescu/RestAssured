import io.restassured.RestAssured;


import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class GetPetTypeById {

    @Test
    public void getTypeById() {  //url cu parametrul din path
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinic/api";
        //RestAssured.basePath = "/pettypes";
        RestAssured.basePath = "/pettypes/{petTypeId}";

        Response response = given().
                pathParam("petTypeId",101).log().all().
                when().
                //get("{petTypeId}").
                 get().
                then().log().body().
                statusCode(HttpStatus.SC_OK).extract().response() ;

        String name = response.path("name");
        Assert.assertTrue(name.equals("Camel"));

        int id = response.path("id"); //extrag id.ul
        Assert.assertEquals(id,101);

    }
}
