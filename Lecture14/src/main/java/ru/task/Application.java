package ru.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;


public class Application {

    //для проверки валидности модели при помощи JSONSchema(everit)
    private static Schema loadSchema() throws IOException{
        try (InputStream inputStream = Application.class.getResourceAsStream("/schema2.json")) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            return SchemaLoader.load(rawSchema);
        }
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException{

        //загрузили схему
        Schema schema = loadSchema();

        //TypeReference itemsArrType = TypeReference<List<Animal>>(){};
        Type itemsArrType = new TypeToken<Animal[]>() {}.getType();

        //загрузили файл для проверки
        String inputJson1 = IOUtils.resourceToString("/json1.json", Charset.defaultCharset());
        String inputJson2 = IOUtils.resourceToString("/json2.json", Charset.defaultCharset());

        //проверка файла на соответствие схеме
        schema.validate(new JSONArray(inputJson1));
        schema.validate(new JSONArray(inputJson2));

        //десериализация JSON в объект
        Animal[] kot1 = GSON.fromJson(inputJson1, itemsArrType);
        Animal[] kot2 = GSON.fromJson(inputJson2, itemsArrType);


        System.out.println("********************************************");
        System.out.println("Model deserialization \n" + Arrays.toString(kot1));
        System.out.println("********************************************");
        //сериализация объекта в JSON в pretty-формате
        String outJson1 = GSON.toJson(kot1);
        System.out.println("Model serialization \n" + outJson1);
        System.out.println("********************************************");

        System.out.println("Model deserialization \n" + Arrays.toString(kot2));
        System.out.println("********************************************");
        //сериализация объекта в JSON в pretty-формате
        String outJson2 = GSON.toJson(kot2);
        System.out.println("Model serialization \n" + outJson2);
        System.out.println("********************************************");


/*

        //создаём экземпляр для сериализации и десериализации
        Animal cat = new Animal("cat", "Vasya", 25, true, Arrays.asList("white","orange","black"),new CatFriends(3));

        //сериализация объекта в JSON в pretty-формате
        String json = GSON.toJson(cat);
        System.out.println(json);

        //десериализация JSON в объект
        Animal cat2 = GSON.fromJson(json, Animal.class);
        System.out.println(cat2);

 */
    }
}
