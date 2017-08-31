import java.util.List;
import java.util.stream.Collectors;

public class MarksAggregator {

    public List<String> getStudentsIndexWithEndGradeNotPositive(List<Student> input) {
        return input.stream()
                .filter(student -> student.getEndGrade() == 2.0)
                .map(Student::getIndex)
                .collect(Collectors.toList());
    }

    public List<String> getStudentsIndexWithEndGradePositive(List<Student> input) {
        return input.stream()
                .filter(student -> student.getEndGrade() > 2.0)
                .map(Student::getIndex)
                .collect(Collectors.toList());
    }

    public long getNumberPassed(List<Student> input){
        return input.stream()
                .filter(student -> student.getEndGrade() > 2.0)
                .count();
    }

    public long getNumberNotPassed(List<Student> input){
        return input.stream()
                .filter(student -> student.getEndGrade() == 2.0)
                .count();
    }
}
