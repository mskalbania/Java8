import java.util.*;

public class Lambdas {

    public static void main(String[] args) {

        Employee first = new Employee("aa", 12);
        Employee second = new Employee("bb", 32);
        Employee third = new Employee("cc", 43);
        Employee fourth = new Employee("dd", 23);

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(first, second, third, fourth));

        //OLD WAY
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee t1, Employee t2) {
                if (t1.getAge() == t2.getAge()) return 0;
                else if (t1.getAge() > t2.getAge()) return 1;
                else return -1;
            }
        });

        employeeList.forEach(e -> System.out.println(e.getName() + " " + e.getAge()));
        ///

        //NEW WAY
        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareTo(e2.getName()));

        employeeList.forEach(e -> System.out.println(e.getName() + " " + e.getAge()));
        ///

        employeeList.forEach(e -> {
            System.out.println(e.getName());
            new Thread(() -> System.out.println(e.getAge())).start();
        });


        String someString = doSomething((s1, s2) -> {
            String result = s1.concat(s2);
            return result;
        }, "22", "33");

        System.out.println(someString);

        System.out.println(new Lambdas2().someMethod());
    }

    public static String doSomething(SomeInterface sf, String s1, String s2) {
        return sf.returnSomething(s1, s2);
    }

}

class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}