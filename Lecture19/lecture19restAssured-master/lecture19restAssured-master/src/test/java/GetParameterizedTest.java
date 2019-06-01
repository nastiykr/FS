import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetParameterizedTest extends BaseTest{

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "/users/google",
            "/users/google/repos"})
    void baseUrlShouldReturn200(String path){
        prepareRequest().get(path).then().statusCode(200);
    }
}
