import java.util.*;

public class Lambdas {

    public static void main(String[] args) {

        new Thread(new Run()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Started 2");
            }
        }).start();

        new Thread(() -> System.out.println("Started 3")).start();

        new Thread(() -> {
            System.out.println("Started 4");
            System.out.println("Started 5");
        }).start();

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

        //NEW WAY
        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareTo(e2.getName()));

        employeeList.forEach(e -> System.out.println(e.getName() + " " + e.getAge()));
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

class Run implements Runnable {
    @Override
    public void run() {
        System.out.println("Started 1");
    }
}
