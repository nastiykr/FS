import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import ru.cft.focus.model.Repo;

import static ru.cft.focus.constants.Credentials.USER;

public class PostTest extends BaseTest{

    @Test
    void createRepo(){
        Repo newRepo = new Repo("newRepo", "Some description");

        prepareRequest()
                .contentType(ContentType.JSON)
                .body(newRepo)
                .post("/user/repos")
                .then().statusCode(201);
    }

        @Test
        void deleteRepo(){
            prepareRequest()
                    .delete("/repos/" + USER + "/newRepo")
                    .then().statusCode(204);
        }
}
