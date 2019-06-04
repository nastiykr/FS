import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import ru.cft.focus.model.Repo;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.cft.focus.api.HttpMethods.post;
import static ru.cft.focus.constants.Credentials.USER;

public class PostStepTest extends BaseTest{

    @Test
    void createRepo(){
        Repo newRepo = new Repo("newRepo", "Some description");

        Response response = post("/user/repos", newRepo);

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    void deleteRepo(){
        prepareRequest()
                .delete("/repos/" + USER + "/newRepo")
                .then().statusCode(204);
    }
}
