import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NamesReader {

    public static List<String> readNames(String path) {

        Path filePath = Paths.get(path);
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
