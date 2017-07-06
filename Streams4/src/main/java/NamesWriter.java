import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NamesWriter {

    public static void writeNames(List<String> names, String path) {
        try {
            Path filePath = Paths.get(path);
            Files.write(filePath, names);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
