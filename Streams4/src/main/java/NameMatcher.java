import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NameMatcher {

    public boolean hasAnyNameOfLength(List<String> inputList, int length) {

        return inputList.stream()
                .anyMatch(name -> name.length() == length);
    }

    public boolean areAllNamesOfLength(List<String> inputList, int length) {

        return inputList.stream()
                .allMatch(name -> name.length() == length);

    }

    public boolean areAllNamesHaveAtLeastOneVowel(List<String> inputList) {

        if (inputList.isEmpty()) return false;
        return inputList.stream()
                .allMatch(name -> Pattern.compile("[aeouyi]").matcher(name).find());
    }

    public List<String> sortByLength(List<String> inputList) {

        return inputList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> getOnlyFemales(List<String> inputList) {

        return inputList.stream()
                .filter(name -> name.endsWith("a"))
                .collect(Collectors.toList());
    }

    public List<String> getOnlyMales(List<String> inputList) {

        return inputList.stream()
                .filter(name -> !name.endsWith("a"))
                .collect(Collectors.toList());
    }

    public List<String> sortByGender(List<String> inputList) {

        List<String> output = new ArrayList<>();

        List<String> females = getOnlyFemales(inputList);
        List<String> males = getOnlyMales(inputList);

        Collections.sort(females);
        Collections.sort(males);

        output.addAll(females);
        output.addAll(males);

        return output;
    }
}
