package ru.task;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

        //загрузили файл для проверки
        val inputJson1 = IOUtils.resourceToString("/json1.json", Charset.defaultCharset());
        val inputJson2 = IOUtils.resourceToString("/json2.json", Charset.defaultCharset());

        //проверка файла на соответствие схеме
        schema.validate(new JSONObject(inputJson1));
        schema.validate(new JSONObject(inputJson2));

        //десериализация JSON в объект
        Animal kot1 = GSON.fromJson(inputJson1, Animal.class);
        System.out.println("********************************************");
        System.out.println("Дессериализация модели \n" + kot1);
        System.out.println("********************************************");
        //сериализация объекта в JSON в pretty-формате
        String outJson1 = GSON.toJson(kot1);
        System.out.println("Сериализация модели \n" + outJson1);
        System.out.println("********************************************");

        //десериализация JSON в объект
        Animal kot2 = GSON.fromJson(inputJson2, Animal.class);
        System.out.println("Дессериализация модели \n" + kot2);
        System.out.println("********************************************");
        //сериализация объекта в JSON в pretty-формате
        String outJson2 = GSON.toJson(kot2);
        System.out.println("Сериализация модели \n" + outJson2);
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
