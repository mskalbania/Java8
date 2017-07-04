import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ConstantConditions")
public class PeopleAggregationTest {

    private PeopleAggregation testAggregator;
    private List<Person> testList;


    @Before
    public void setUp() {
        testAggregator = new PeopleAggregation();
        testList = getPersonList();
    }

    @Test
    public void shouldReturnNotNullValueWhenAskedForAverageAge() {
        OptionalDouble respond = testAggregator.getAverageAge(testList);
        assertThat(respond.isPresent()).isTrue();
    }

    @Test
    public void shouldReturnCorrectAverageAge() {
        OptionalDouble respond = testAggregator.getAverageAge(testList);
        long rounded = Math.round(respond.getAsDouble());
        assertThat(rounded).isEqualTo(37);
    }

    @Test
    public void shouldCorrectlyReturnWomenAmount() {
        long respond = testAggregator.getTotalWomen(testList);
        assertThat(respond).isEqualTo(4L);
    }

    @Test
    public void shouldCorrectlyReturnManAmount() {
        long respond = testAggregator.getTotalMen(testList);
        assertThat(respond).isEqualTo(3L);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenListIsEmptyAndAskedForYoungest() {
        testList.clear();
        testAggregator.getYoungestPerson(testList);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenListIsEmptyAndAskedForOldest() {
        testList.clear();
        testAggregator.getOldestPerson(testList);
    }

    @Test
    public void shouldCorrectlyReturnYoungestPerson() {
        Person respond = testAggregator.getYoungestPerson(testList);
        assertThat(respond.getAge()).isEqualTo(22);
    }

    @Test
    public void shouldCorrectlyReturnOldestPerson() {
        Person respond = testAggregator.getOldestPerson(testList);
        assertThat(respond.getAge()).isEqualTo(65);
    }

    @Test
    public void shouldCorrectlyReturnMapWhenAskedForAggregateById() {
        Map<Integer, Person> respond = testAggregator.aggregateById(testList);
        assertThat(respond).isNotNull();
    }

    private List<Person> getPersonList() {
        String path = System.getProperty("user.dir")
                .concat("/src/test/java/peopleTestList.csv");

        return PeopleLoader.loadPeopleFromFile(path);
    }
}