import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    //Some tests of functional interfaces

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee("Name1 Surname1", 21),
                new Employee("Name2 Surname2", 44),
                new Employee("Name3 Surname3", 55),
                new Employee("Name4 Surname4", 32)));

        employeeList.forEach(employee -> System.out.println(employee.getName() + " " + employee.getAge()));

        //Predicate way
        printEmployeesByAge(employeeList, "30", employee -> employee.getAge() >= 30);

        //Stream way + sorted
        System.out.println("Sorted employees over 30");
        employeeList.stream()
                .filter(employee -> employee.getAge() > 30)
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) return 0;
                    else if (e1.getAge() > e2.getAge()) return 1;
                    else return -1;
                })
                .forEach(employee -> System.out.println(employee.getName() + " " + employee.getAge()));

        //Functions
        Function<Employee, String> getLastName = (Employee e) -> {
            String name = e.getName();
            return name.substring(name.indexOf(' ') + 1, name.length());
        };

        System.out.println("\nPrinting only surnames");
        employeeList.forEach(e -> System.out.println(getLastName.apply(e)));

        //Chain Functions

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chain = upperCase.andThen(firstName);
        System.out.println("\nPrinting names uppercase via chain function");
        employeeList.forEach(e -> System.out.println(chain.apply(e)));

        //BiFunctions

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) ->
                name.concat(" " + employee.getAge());

        System.out.println("\n Example of BiFunctions");
        //employeeList.forEach(e -> System.out.println(concatAge.apply(((String) chain.apply(e)),e)));
        employeeList.forEach(e -> {
            String temp = ((String) chain.apply(e));
            System.out.println(concatAge.apply(temp,e));
        });

    }

    public static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println("Employees by age " + ageText);

        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + " " + employee.getAge());
            }
        }
    }
}
