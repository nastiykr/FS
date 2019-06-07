import model.Repo;
import org.junit.jupiter.api.Test;


public class RepoTest extends BaseTest {
    @Test
    void createRepo(){
        Repo repo = new Repo("my_issue_1","some_1");

        prepareRequest()
                .body(repo)
                .post("/user/repos")
                .then()
                .statusCode(201);
    }

    @Test
    void deleteRepo(){
        prepareRequest()
                .delete("/repos/nastiykr/my_issue_1")
                .then().statusCode(204);
    }
}
