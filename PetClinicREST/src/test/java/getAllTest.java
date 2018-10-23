import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class getAllTest {

    @Test
    public void getTest(){
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
        RestAssured.basePath = "/user_timeline.json";

        given().
                auth().
                //  oauth("consumerKey", "consumerSecret", "accessTokenSecret","secretToken").
                oauth("r1SktL1rdaFe3jsF7uaC46uky", "M3Y72JtfLgNruQMXJloFlXPIpd61QGV2rERgNe9ZmSMlPLyO62", "4923063747-u2L19lo0t5L5k6I5XLGlMGVN6cq2qzMWDsahCVR","O28DGNswrwhdcLD9ehv97TJPMqHZ7OyMZxVpOjsmTbgCQ").
                when().
                get().
                then().assertThat().body("text",hasItems("Geo")).log().all();
                //extract().response().body().path("Geo");




    }

}
