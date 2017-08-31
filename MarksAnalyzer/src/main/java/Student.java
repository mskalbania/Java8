public class Student {

    private String index;
    private Double theoreticalGrade;
    private Double practicalGrade;
    private Double endGrade;

    public Student(String index, Double theoreticalGrade, Double practicalGrade, Double endGrade) {
        this.index = index;
        this.theoreticalGrade = theoreticalGrade;
        this.practicalGrade = practicalGrade;
        this.endGrade = endGrade;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setTheoreticalGrade(Double theoreticalGrade) {
        this.theoreticalGrade = theoreticalGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index='" + index + '\'' +
                ", theoreticalGrade=" + theoreticalGrade +
                ", practicalGrade=" + practicalGrade +
                ", endGrade=" + endGrade +
                '}';
    }

    public void setPracticalGrade(Double practicalGrade) {
        this.practicalGrade = practicalGrade;
    }

    public void setEndGrade(Double endGrade) {
        this.endGrade = endGrade;
    }

    public String getIndex() {
        return index;
    }

    public Double getTheoreticalGrade() {
        return theoreticalGrade;
    }

    public Double getPracticalGrade() {
        return practicalGrade;
    }

    public Double getEndGrade() {
        return endGrade;
    }
}
