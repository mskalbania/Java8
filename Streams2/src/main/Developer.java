import java.util.Set;

public class Developer {

    private String name;
    private int age;
    private Set<String> knownLanguages;

    public Developer(String name, int age, Set<String> knownLanguages) {
        this.name = name;
        this.age = age;
        this.knownLanguages = knownLanguages;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getKnownLanguages() {
        return knownLanguages;
    }

    public static DeveloperBuilder createDeveloper() {
        return new DeveloperBuilder();
    }

    @Override
    public String toString() {
        return name + " " + age + " " + knownLanguages.toString();
    }

}
