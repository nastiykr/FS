import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static ru.cft.focus.constants.Credentials.PASSWORD;
import static ru.cft.focus.constants.Credentials.USER;
import static ru.cft.focus.constants.Path.BASE_URL;

public class BaseTest {
    protected static RequestSpecification prepareRequest() {
        /*RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())*/


        return given()
                .auth()
                .preemptive()
                .basic(USER, PASSWORD)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .baseUri(BASE_URL);
    }
}
