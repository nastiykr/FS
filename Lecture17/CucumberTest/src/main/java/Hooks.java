import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void before(){
        System.out.println("Эта строка выводится перед каждым сценарием");
    }

    @After
    public void after(){
        System.out.println("Эта строка выводится после каждого сценария");
    }
}