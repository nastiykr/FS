import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetParameterizedPathTest extends BaseTest{

    @ParameterizedTest
    @ValueSource(strings = {
            "microsoft",
            "apache",
            "alibaba",
            "google",})
    void baseUrlShouldReturn200(String user){
        prepareRequest()
                .param("sort", "created")
                .pathParam("user", user)
                .get("/users/{user}/repos").then().statusCode(200);
    }
}
