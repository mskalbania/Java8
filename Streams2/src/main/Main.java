import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
//
//        BinaryOperator<Integer> add = (number1, number2) -> number1 + number2;
//        BinaryOperator<Integer> subtract = (number1, number2) -> number1 - number2;
//        BinaryOperator<Integer> multiply = (number1, number2) -> number1 * number2;
//        BinaryOperator<Integer> divide = (number1, number2) -> number1 / number2;
//
//        //adding first 10 numbers
//        System.out.println(
//                IntStream.range(1, 11)
//                        .boxed()
//                        .reduce(0, add));
//        //multiplying 10 numbers
//        System.out.println(
//                IntStream.range(1, 11)
//                        .boxed()
//                        .reduce(1, multiply)
//        );
//        //first 10 numbers / 3
//        IntStream.iterate(1, i -> i + 1)
//                .filter(i -> i % 3 == 0)
//                .limit(10)
//                .forEach(System.out::println);

        Set<Developer> developers = createDevelopers();
        //Showing all known languages by devs
        developers.stream()
                .flatMap(dev -> dev.getKnownLanguages().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        printSeparator();
        //Showing all languages containing letter c in name
        developers.stream()
                .flatMap(dev -> dev.getKnownLanguages().stream())
                .distinct()
                .filter(language -> language.contains("c") || language.contains("C"))
                .forEach(System.out::println);

        printSeparator();
        //Showing all devs knowing more than 3 languages
        developers.stream()
                .filter(dev -> dev.getKnownLanguages().size() >= 4)
                .forEach(System.out::println);

        printSeparator();
        //Showing average age of devs
        developers.stream()
                .mapToInt(Developer::getAge)
                .average()
                .ifPresent(output -> System.out.println("AVERAGE: " + Math.round(output)));

        printSeparator();
        //Showing oldest dev
        developers.stream()
                .reduce((dev1, dev2) -> dev1.getAge() > dev2.getAge() ? dev1 : dev2)
                .ifPresent(System.out::println);

        printSeparator();
        //Sorting devs via Name
        developers.stream()
                .sorted(Comparator.comparing(Developer::getName))
                .forEach(System.out::println);

        printSeparator();
        //Soring via age
        developers.stream()
                .sorted(Comparator.comparing(Developer::getAge))
                .forEach(System.out::println);

        printSeparator();
        //Grouped devs by age
        Map<Integer, List<Developer>> groupByAge = developers
                .stream()
                .collect(Collectors.groupingBy(Developer::getAge));

        for(Map.Entry entry : groupByAge.entrySet()){
            System.out.println(entry.getKey() + ":");
            for (Developer dev : (List<Developer>) entry.getValue()){
                System.out.println("-> " + dev);
            }
        }

        ///////////////////////////////////////////////////
        printSeparator();
        printSeparator();

        //Predicating if sum of digits is equal to 7
        Predicate<Integer> sumOfDigitsEqualsTo7 = integer -> {
            String intAsString = integer.toString();
            Integer value = 0;
            for(String s : intAsString.split("")){
                value += Integer.parseInt(s);
            }
            return value == 7;
        };

        IntStream.range(1,101)
                .boxed()
                .filter(sumOfDigitsEqualsTo7)
                .forEach(System.out::println);

        printSeparator();
        //second way
        Predicate<Integer> sumOfDigitsEqualsTo7ExternalImplementation = new MyPredicate();
        IntStream.range(1,40)
                .boxed()
                .filter(sumOfDigitsEqualsTo7ExternalImplementation)
                .forEach(System.out::println);
    }

    public static Set<Developer> createDevelopers() {

        Set<Developer> devSet = new HashSet<>();
        Developer dev1 = Developer.createDeveloper()
                .withName("Andrzej")
                .withAge(37)
                .withLanguages("Java", "C#", "JavaScript", "C++")
                .create();
        devSet.add(dev1);

        Developer dev2 = Developer.createDeveloper()
                .withName("Tomek")
                .withAge(24)
                .withLanguages("HTML", "Scala", "Haskell")
                .create();
        devSet.add(dev2);

        Developer dev3 = Developer.createDeveloper()
                .withName("Bartek")
                .withAge(29)
                .withLanguages("Groovy", "CSS", "JavaScript", "HTML")
                .create();
        devSet.add(dev3);

        Developer dev4 = Developer.createDeveloper()
                .withName("Dorota")
                .withAge(33)
                .withLanguages("Java", "SQL")
                .create();
        devSet.add(dev4);

        Developer dev5 = Developer.createDeveloper()
                .withName("Patryk")
                .withAge(28)
                .withLanguages("CSS", "JavaScript", "HTML", "JQuery")
                .create();
        devSet.add(dev5);

        Developer dev6 = Developer.createDeveloper()
                .withName("Iwona")
                .withAge(28)
                .withLanguages("CSS", "JavaScript", "HTML")
                .create();
        devSet.add(dev6);

        return devSet;
    }

    public static void printSeparator() {
        System.out.println("-------------------");
    }


}
