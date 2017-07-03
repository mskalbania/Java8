import java.util.function.Predicate;

public class MyPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        String intAsString = integer.toString();
        Integer value = 0;
        for(String s : intAsString.split("")){
            value += Integer.parseInt(s);
        }
        return value == 7;
    }
}
