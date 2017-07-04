import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class PeopleAggregation {

    public OptionalDouble getAverageAge(List<Person> inputList) {

        return inputList.stream()
                .mapToInt(Person::getAge)
                .average();
    }

    public long getTotalWomen(List<Person> inputList) {

        return inputList.stream()
                .filter(person -> person.getGender() == Person.Gender.Female)
                .count();
    }

    public long getTotalMen(List<Person> inputList) {

        return inputList.stream()
                .filter(person -> person.getGender() == Person.Gender.Male)
                .count();
    }

    public Person getYoungestPerson(List<Person> inputList) {

        Optional<Person> person = inputList
                .stream()
                .reduce((person1, person2) -> person1.getAge() < person2.getAge() ? person1 : person2);

        if (person.isPresent()) {
            return person.get();
        } else {
            throw new RuntimeException("Not found youngest person. List is empty");
        }
    }

    public Person getOldestPerson(List<Person> inputList) {

        Optional<Person> person = inputList
                .stream()
                .reduce(((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2));

        if (person.isPresent()) {
            return person.get();
        } else {
            throw new RuntimeException("Not found youngest person. List is empty");
        }
    }

    public Map<Integer, Person> aggregateById(List<Person> inputList) {

        return inputList.stream()
                .collect(Collectors.toMap(Person::getId, person -> person));
    }


}
