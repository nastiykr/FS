package assertjdemo.diff;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertJ {
    @Test
    void diff(){
        String a = "a";
        String b = "b";

        assertEquals(a,b);
        assertThat(a).isEqualTo(b); //AssertJ
    }
}
