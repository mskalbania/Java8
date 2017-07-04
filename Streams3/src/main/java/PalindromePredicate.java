import java.util.Arrays;
import java.util.Stack;
import java.util.function.Predicate;

public class PalindromePredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        String parsedNumber = integer.toString();
        String[] digits = parsedNumber.split("");
        if(digits.length == 1) return false;
        Stack<String> stack = new Stack<>();
        Arrays.stream(digits).forEach(stack::push);
        for(int i = 0; i < digits.length/2; i++){
            if(!digits[i].equals(stack.pop())){
                return false;
            }
        }
        return true;
    }
}
