import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromePredicateTest {

    private PalindromePredicate predicate;

    @Before
    public void setUp(){
        predicate = new PalindromePredicate();
    }

    @Test
    public void shouldReturnTrueWhenNumberIsPalindrome() {
        List<Integer> palindromes = Arrays.asList(11, 121, 123454321);

        for(Integer i : palindromes){
            assertThat(predicate.test(i)).isTrue();
        }
    }

    @Test
    public void shouldReturnFalseWhenNumberIsNotPalindrome(){
        List<Integer> palindromes = Arrays.asList(10, 132, 153554529);

        for(Integer i : palindromes){
            assertThat(predicate.test(i)).isFalse();
        }
    }


}