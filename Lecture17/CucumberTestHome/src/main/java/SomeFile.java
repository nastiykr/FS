import lombok.Getter;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@Getter
public class SomeFile {

    private String file;
    Path directoryPath;

    public SomeFile(String path) {
        this.file = path;
    }

    public void createFile() {
        directoryPath = Paths.get(this.file);
        try {
            Files.createDirectory(directoryPath);
        } catch (IOException e) {
        }

    }
    public boolean getFilePath() {
        boolean fileExists = Files.exists(directoryPath);
        return fileExists;
    }
}
