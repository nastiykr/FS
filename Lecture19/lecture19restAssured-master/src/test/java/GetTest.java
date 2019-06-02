import org.junit.jupiter.api.Test;

public class GetTest extends BaseTest{

    @Test
    void baseUrlShouldReturn200(){
        prepareRequest()
                .get()
                .then().statusCode(200);
    }

    @Test
    void getUserShouldReturn200(){
        prepareRequest()
                .get("/users/google")
                .then().statusCode(200);
    }

    @Test
    void getUserReposShouldReturn200(){
        prepareRequest()
                .get("/users/google/repos")
                .then().statusCode(200);
    }
}
