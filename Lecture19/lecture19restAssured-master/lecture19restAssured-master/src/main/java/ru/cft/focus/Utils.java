package ru.cft.focus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import ru.cft.focus.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String getResourceAsString(final String filePath) {
        try(InputStream inputStream = Utils.class.getResourceAsStream(filePath)){
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User jsonToModelUser(String json){
        ObjectMapper mapper = new ObjectMapper();
        User result = null;
        try {
            result = (User) mapper.readValue(json, User.class);
        } catch (IOException e){e.printStackTrace();}
        return result;
    }
}
