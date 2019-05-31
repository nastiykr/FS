import lombok.Getter;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@Getter
public class SomeFile {

    private String file;
    Path directoryFile;

    public SomeFile(String path) {
        this.file = path;
    }

    public void createFile() {
        directoryFile = Paths.get(this.file);
        try {
            Files.createFile(directoryFile);
        } catch (IOException e) {
            System.out.println("Файл уже существует!");
        }
    }
    public boolean getFilePath() {
        boolean fileExists = Files.exists(directoryFile);
        return fileExists;
    }
}
