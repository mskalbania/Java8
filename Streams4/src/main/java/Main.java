import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        NameMatcher matcher = new NameMatcher();
        List<String> names = NamesReader.readNames("names.txt");

        List<String> females = matcher.getOnlyFemales(names);
        NamesWriter.writeNames(females, "females.txt");

        List<String> males = matcher.getOnlyMales(names);
        NamesWriter.writeNames(males, "males.txt");

    }
}
