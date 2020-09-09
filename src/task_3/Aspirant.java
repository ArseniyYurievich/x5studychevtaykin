package task_3;

public class Aspirant extends Student {
    private String study;

    @Override
    public int getScholarship() {
        return averageMark == 5 ? 200 : 180;
    }

    public Aspirant(String firstName, String lastName, String group, double averageMark, String study) {
        super(firstName, lastName, group, averageMark);
        this.study = study;
    }
}
