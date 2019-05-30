import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import java.io.File;

public class SomeFileTest {


    @Дано("^Пользователь создаёт объект типа SomeFile, где filePath равен \"([^\"]*)\"$")
    public void пользовательСоздаётОбъектТипаSomeFileГдеfilePathРавен(String path) {
        TestContext.instance = new SomeFile(path);
        System.out.println("Дано. Имя файла для создания  = " + path);
    }

    @Когда("Пользователь вызывает метод создания filePath")
    public void пользовательВызываетМетодСозданияFilePath( ) {
        TestContext.instance.createFile();
        System.out.println(" **********************");
        System.out.println("Когда. Файл создан");
    }

    @Тогда("filePath создан, на экран выводится сообщение равное {string}")
    public void filepathСозданНаЭкранВыводитсяСообщениеРавное() {
        String targetValue = TestContext.instance.getFilePath();

        Assert.assertEquals("ff", targetValue);
        System.out.println(" **********************");
        System.out.println("Тогда. Проверка существования файла");
    }
}


