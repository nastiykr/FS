import io.restassured.response.Response;
import model.Issue;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class EditIssue extends BaseTest {
    @Test
    void editUserIssues(){
        Issue issue2 = new Issue("my_title_2","my_body",null);
        prepareRequest()
                .body(issue2)
                .post("/repos/nastiykr/my_issue_1/issues")
                .then()
                .statusCode(201);



        Issue issue3 = new Issue("my_title","EdiT!!!");
        prepareRequest()
                .body(issue3)
                .patch("/repos/nastiykr/my_issue_1/issues/1")
                .then()
                .statusCode(200);



        Response response = prepareRequest().get("/repos/nastiykr/my_issue_1/issues/1");
        response.body().jsonPath().get("body");

        response.then().body("body", equalTo("EdiT!!!"));
    }
}
