import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeveloperBuilder {

    private String name;
    private int age;
    private Set<String> knownLanguages;

    public DeveloperBuilder() {
        this.name = null;
        this.age = -1;
        this.knownLanguages = new HashSet<>();
    }

    public DeveloperBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DeveloperBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public DeveloperBuilder withLanguages(String... languages) {
        this.knownLanguages.addAll(Arrays.asList(languages));
        return this;
    }

    public Developer create() {
        return new Developer(name, age, knownLanguages);
    }
}
