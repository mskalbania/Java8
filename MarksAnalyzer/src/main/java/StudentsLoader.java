import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsLoader {

    public static List<Student> loadStudents() {
        String path = Paths.get("").toAbsolutePath().toString()
                .concat("/src/main/resources/oceny.txt");
        List<Student> output = new ArrayList<>();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");

                String index = values[0];
                Double firstGrade = Double.parseDouble(values[1]);
                Double secondGrade = Double.parseDouble(values[2]);
                Double thirdGrade = Double.parseDouble(values[3]);

                output.add(new Student(index, firstGrade, secondGrade, thirdGrade));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return output;
    }
}
