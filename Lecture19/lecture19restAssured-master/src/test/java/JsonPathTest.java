import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPathTest extends BaseTest{

    @Test
    void jsonTest(){
        Response response = prepareRequest().get("/users/google");
        int public_repos = response.body().jsonPath().get("public_repos");
        assertEquals(public_repos, 10);

        response.then().body("public_repos", equalTo(1494));
    }

    @Test
    void jsonListTest(){
        Response response = prepareRequest().get("/users/google/repos");

        response.then().body("[0].owner.login", equalTo("google"));
    }


}
