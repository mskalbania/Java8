public class Lambdas2 {

    public String someMethod() {
        return Lambdas.doSomething((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(), "string1", "string2");
    }

}
