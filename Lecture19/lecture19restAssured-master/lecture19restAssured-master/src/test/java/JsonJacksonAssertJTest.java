import org.junit.jupiter.api.Test;
import ru.cft.focus.model.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.cft.focus.Utils.getResourceAsString;
import static ru.cft.focus.Utils.jsonToModelUser;

public class JsonJacksonAssertJTest extends BaseTest{

    @Test
    void jsonTestWithObjects(){
        User expected = new User("microsoft", 6154722, "MDEyOk9yZ2FuaXphdGlvbjYxNTQ3MjI=");

        User microsoft =
            prepareRequest()
                    .get("/users/microsoft")
                    .body().as(User.class);
        assertThat(expected).isEqualToComparingFieldByField(microsoft);
    }

    @Test
    void jsonTestWithObjectsWithFile(){
        User expected = jsonToModelUser(getResourceAsString("/microsoft.json"));

        User microsoft =
            prepareRequest()
                    .get("/users/microsoft")
                    .body().as(User.class);

        assertThat(expected).isEqualToComparingFieldByField(microsoft);
    }
}
