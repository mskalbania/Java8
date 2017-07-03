import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class MyPredicateTest {

    private Predicate<Integer> predicate;

    @BeforeEach
    public void setup() {
        predicate = new MyPredicate();
    }


    @Test
    public void shouldReturnTrueWhenSumOfDigitsEqualsTo7() {

        List<Integer> testList = Arrays.asList(16, 25, 34, 43, 52, 61, 70);

        for (Integer integer : testList) {
            assertEquals(predicate.test(integer), true);
        }
    }

    @Test
    public void shouldReturnFalseWhenSumOfDigitsNotEqualsTo7() {

        List<Integer> testList = Arrays.asList(11, 23, 54, 13, 262, 178, 10);

        for (Integer integer : testList) {
            assertEquals(predicate.test(integer), false);
        }
    }
}