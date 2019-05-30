import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@Getter
public class SomeFile {

    private String file;

    public SomeFile(String path) {
        this.file = path;
    }

    public void createFile() {
        Path directoryPath = Paths.get(this.file);
        try {
            Files.createDirectory(directoryPath);
        } catch (IOException e) {
        }

    }
    public String getFilePath() {

        return this.file;
    }
}
