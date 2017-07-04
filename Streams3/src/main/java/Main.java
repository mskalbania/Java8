import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@SuppressWarnings("ConstantConditions")
public class Main {
    public static void main(String[] args) {
        List<Person> personList = PeopleLoader.loadPeopleFromFile("/home/mateusz/Downloads/people.csv");
        PeopleAggregation aggregator = new PeopleAggregation();


        System.out.println("AVERAGE - " + Math.round(aggregator.getAverageAge(personList).getAsDouble()));
        System.out.println("TOTAL MEN - " + aggregator.getTotalMen(personList));
        System.out.println("TOTAL WOMEN - " + aggregator.getTotalWomen(personList));
        System.out.println("YOUNGEST PERSON - " + aggregator.getYoungestPerson(personList));
        System.out.println("OLDEST PERSON - " + aggregator.getOldestPerson(personList));
        //MAP
        System.out.println("---------------------------------");
        Map<Integer, Person> personsMappedById = aggregator.aggregateById(personList);
        for (Map.Entry entry : personsMappedById.entrySet()) {
            System.out.println("ID -> " + entry.getKey() + " <- ID");
            System.out.println(entry.getValue());
        }
        //Palindrome Predicate
        Predicate<Integer> isPalindrome = new PalindromePredicate();
        Consumer<Integer> writeToFile = new WriterConsumer(System.getProperty("user.dir") + "/results.txt");

        IntStream.iterate(1, i -> i + 1)
                .boxed()
                .filter(isPalindrome)
                .limit(100_000_000L)
                .forEach(writeToFile);
    }

}
