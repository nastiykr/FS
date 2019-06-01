import org.junit.jupiter.api.Test;
import ru.cft.focus.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonJacksonTest extends BaseTest{

    @Test
    void jsonTest(){
        User microsoft =
            prepareRequest()
                    .get("/users/microsoft")
                    .body().as(User.class);
        assertEquals("microsoft", microsoft.login);
        assertEquals(6154722, microsoft.id);
        assertEquals("MDEyOk9yZ2FuaXphdGlvbjYxNTQ3MjI=", microsoft.node_id);
    }
}
