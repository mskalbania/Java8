import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //1

        Runnable runnable = () -> {
            String myString = "Some string being split up to array";
            String[] parts = myString.split(" ");
            for (String s : parts) {
                System.out.println(s);
            }
        };

        //2

        Function<String, String> everySecondChar = s -> {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    output.append(s.charAt(i));
                }
            }
            return output.toString();
        };

        //3

        System.out.println(implementationOf2(everySecondChar, "1234567890"));

        //4

        Supplier<String> supplier = () -> "Supplier supplied";

        //5

        System.out.println(supplier.get());

        //6

        List<String> names = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob");
        names.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //7

        System.out.println(names.stream()
                .filter(s -> s.toUpperCase().startsWith("A"))
                .count());

        //8

        long nameAmount = names.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .peek(s -> System.out.print(s + " "))
                .count();

        System.out.println("\nThere is " + nameAmount + " names");

    }

    public static String implementationOf2(Function<String, String> f, String input) {
        return f.apply(input);
    }
}
