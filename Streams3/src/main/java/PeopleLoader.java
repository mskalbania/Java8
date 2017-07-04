import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeopleLoader {

    public static List<Person> loadPeopleFromFile(String path) {
        List<Person> output = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))) {
            while (scanner.hasNext()){
                Person tempPerson = new Person();
                String line = scanner.nextLine();
                String[] values = line.split(",");
                tempPerson.setId(Integer.parseInt(values[0]));
                tempPerson.setName(values[1]);
                if(values[2].equals("male")){
                    tempPerson.setGender(Person.Gender.Male);
                }else {
                    tempPerson.setGender(Person.Gender.Female);
                }
                tempPerson.setAge(Integer.parseInt(values[3]));
                tempPerson.setJob(values[4]);
                output.add(tempPerson);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return output;
    }


}
