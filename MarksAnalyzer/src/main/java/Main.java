import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentsList = StudentsLoader.loadStudents();
        MarksAggregator aggregator = new MarksAggregator();

        System.out.println("NOT PASSED");
        aggregator.getStudentsIndexWithEndGradeNotPositive(studentsList)
                .forEach(System.out::println);

        System.out.println("\nPASSED");
        aggregator.getStudentsIndexWithEndGradePositive(studentsList)
                .forEach(System.out::println);

        System.out.println("\nPASSED : " + aggregator.getNumberPassed(studentsList));
        System.out.println("\nNOT PASSED : " + aggregator.getNumberNotPassed(studentsList));

        System.out.println("\nPASSING RATIO : " +
                ((double) aggregator.getNumberNotPassed(studentsList) / (double) studentsList.size() * 100));
    }
}
