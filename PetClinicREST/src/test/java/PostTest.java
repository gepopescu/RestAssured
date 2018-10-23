import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostTest {

    @Test
    public void postTest(){
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
        RestAssured.basePath = "/update.json";

        given().
                auth().
              //  oauth("consumerKey", "consumerSecret", "accessTokenSecret","secretToken").
                      oauth("r1SktL1rdaFe3jsF7uaC46uky", "M3Y72JtfLgNruQMXJloFlXPIpd61QGV2rERgNe9ZmSMlPLyO62", "4923063747-u2L19lo0t5L5k6I5XLGlMGVN6cq2qzMWDsahCVR","O28DGNswrwhdcLD9ehv97TJPMqHZ7OyMZxVpOjsmTbgCQ").
                queryParam("status","Geo").
                log().all().
                when().
                post().
                then().
                log().
                all();
               // then().log().body().
               // statusCode(HttpStatus.SC_CREATED);


    }


}
