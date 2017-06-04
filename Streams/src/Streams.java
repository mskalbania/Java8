import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g43",
                "I26", "I17", "I29", "i11",
                "O71");

        //Prints sorted starting with G
        strings
                .stream()
                .filter(s -> s.toUpperCase().contains("G"))
                .sorted((n1, n2) -> {
                    int number1 = Integer.parseInt(n1.substring(1));
                    int number2 = Integer.parseInt(n2.substring(1));
                    if (number1 == number2) return 0;
                    else if (number1 > number2) return 1;
                    else return -1;
                })
                .forEach(s -> System.out.print(s + " "));

        //Collects and sort starting with I
        List<String> iNumbers = strings
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("I"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\nPrints I: ");
        iNumbers.forEach(System.out::println);


        //Debug peek
        System.out.println("Peek method");
        System.out.println(strings
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("N"))
                .peek(s -> System.out.println(s + " "))
                .count());

        //Flat map example

        Employee first = new Employee("First", 22);
        Employee second = new Employee("Second", 33);
        Employee third = new Employee("Third", 11);
        Employee fourth = new Employee("Fourth", 56);

        Department hr = new Department("HR");
        hr.addEmplyee(first);
        hr.addEmplyee(second);
        hr.addEmplyee(third);

        Department finances = new Department("Finances");
        finances.addEmplyee(fourth);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(finances);

        System.out.println("\nPrint & Collect all employees");
        List<Employee> allEmployees = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
//                .collect(Collectors.toList());
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        allEmployees.forEach(System.out::println);

        //Using reduce method
        System.out.println("\nPrinting the youngest employee");
        departments
                .stream()
                .flatMap(s -> s.getEmployees().stream())
                .reduce((e1, e2) -> {
                    if (e1.getAge() < e2.getAge()) return e1;
                    else return e2;
                })
                .ifPresent(System.out::println);


    }
}
