import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void before(){
        System.out.println("*** Эта строка выводится перед каждым сценарием ***");
    }

}