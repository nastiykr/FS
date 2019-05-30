import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

public class SomeInstanceTestSteps {

    @Дано("^У меня есть объект типа SomeInstance, где X равен \"([^\"]*)\"$")
    public void уМеняЕстьОбъектТипаSomeInstanceГдеXРавен(Integer value) {
        TestContext.instance = new SomeInstance(value);
        System.out.println(" Дано. Значение X = " + TestContext.instance.getX());
    }

    @Когда("^Я вызываю метод инкрементирования X$")
    public void яВызываюМетодИнкрементированияX() {
        TestContext.instance.incrementX();
        System.out.println(" Когда. Значение X = " + TestContext.instance.getX());
    }

    @Когда("^Я вызываю метод декрементирования X$")
    public void яВызываюМетодДекрементированияX() {
        TestContext.instance.decrementX();
        System.out.println(" Когда. Значение X = " + TestContext.instance.getX());
    }

    @Тогда("^X становиться равным \"([^\"]*)\"$")
    public void xСтановитьсяРавным(Integer value) {
        Integer targetValue = TestContext.instance.getX();
        Assert.assertEquals(value, targetValue);
        System.out.println(" Тогда. Значение X = " + TestContext.instance.getX());
    }
}