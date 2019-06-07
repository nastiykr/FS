import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static constants.Paths.BASE_URL;
import static constants.Credentials.USER;
import static constants.Credentials.PASSWORD;


import static io.restassured.RestAssured.given;

public class BaseTest {


    static RequestSpecification prepareRequest(){
        return given()
                .auth()
                .preemptive()
                .basic(USER, PASSWORD)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .baseUri(BASE_URL);

    }

    public static Response post (Object body, String url){
        return prepareRequest()
                .body(body)
                .post(url);
    }
}
