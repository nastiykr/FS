import io.restassured.response.Response;
import model.Issue;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class LockIssue extends BaseTest  {
    @Test
    void lockUserIssues(){
        Issue issue3 = new Issue(true);
        prepareRequest()
                .body(issue3)
                .put("/repos/nastiykr/my_issue_1/issues/1/lock")
                .then()
                .statusCode(204);
    }


    @Test
    void checkLockUserIssues(){
        Response response = prepareRequest().get("/repos/nastiykr/my_issue_1/issues");

        response.then().body("[0].locked", equalTo(true));
    }
}
