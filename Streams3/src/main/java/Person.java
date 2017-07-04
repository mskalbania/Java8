public class Person {

    private int id;
    private String name;
    private Gender gender;
    private int age;
    private String job;

    public enum Gender {
        Male,
        Female
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "ID " + id + " | NAME " + name +
                " | GENDER " + gender + " | AGE " + age +
                " | JOB " + job;
    }


}
