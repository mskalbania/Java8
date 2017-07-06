import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NameMatcherTest {

    private NameMatcher nameMatcher;

    @Before
    public void setUp() {
        nameMatcher = new NameMatcher();
    }

    @Test
    public void shouldReturnTrueWhenAllStringsContainsAtLeastOneVowel() {

        List<String> testStrings = Arrays.asList("string", "a", "e", "o", "y", "i");

        assertEquals(nameMatcher.areAllNamesHaveAtLeastOneVowel(testStrings), true);
    }

    @Test
    public void shouldReturnFalseWhenOneOfStringsNotContainAtLeastOneVowel() {

        List<String> testStrings = Arrays.asList("b", "a", "e", "o", "y", "i");

        assertEquals(nameMatcher.areAllNamesHaveAtLeastOneVowel(testStrings), false);
    }

    @Test
    public void shouldReturnFalseWhenListIsEmpty() {

        List<String> testEmptyList = Collections.emptyList();

        assertEquals(nameMatcher.areAllNamesHaveAtLeastOneVowel(testEmptyList), false);
    }

    @Test
    public void shouldCorrectlySortStringsByLength() {

        List<String> testStrings = Arrays.asList("abc", "abcd", "ab", "abcdef", "a");

        List<String> expectedOutput = Arrays.asList("a", "ab", "abc", "abcd", "abcdef");

        assertEquals(nameMatcher.sortByLength(testStrings), expectedOutput);
    }

    @Test
    public void shouldReturnOnlyFemales() {

        List<String> testNames = Arrays.asList("Agata", "Agnieszka", "Ada", "Marek", "Janusz");
        List<String> expectedOutput = Arrays.asList("Agata", "Agnieszka", "Ada");

        assertEquals(nameMatcher.getOnlyFemales(testNames), expectedOutput);
    }

    @Test
    public void shouldReturnOnlyMales(){
        List<String> testNames = Arrays.asList("Agata", "Agnieszka", "Ada", "Marek", "Janusz");
        List<String> expectedOutput = Arrays.asList("Marek", "Janusz");

        assertEquals(nameMatcher.getOnlyMales(testNames), expectedOutput);
    }
}