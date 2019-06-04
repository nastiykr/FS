package utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResourseLoader {
    public static String getResourceAsString(final String filePath) {
        try(InputStream inputStream = ResourseLoader.class.getResourceAsStream(filePath)){
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
