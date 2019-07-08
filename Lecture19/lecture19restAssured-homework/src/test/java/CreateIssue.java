import io.restassured.response.Response;
import model.Issue;
import model.Repo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

public class CreateIssue extends BaseTest {
    @Test
    void createIssue(){

        //создание issue
        Issue issue = new Issue("my_title_1","my_body_1",null, new String[]{"a","b","c"}, new String[]{"nastiykr"});

        prepareRequest()
                .body(issue)
                .post("/repos/nastiykr/my_issue_1/issues")
                .then()
                .statusCode(201);

        //получаем id созданного issue
        Integer id =  prepareRequest().get("/repos/nastiykr/my_issue_1/issues").body().jsonPath().get("[0].id");

        //получение списка всех issue
        prepareRequest()
                .get("/repos/nastiykr/my_issue_1/issues")
                .then().statusCode(200);



        //проверка, что был создан issue c нужным id
        Response response = prepareRequest().get("/repos/nastiykr/my_issue_1/issues");
        response.then().body("[0].id", equalTo(id));
    }

}
