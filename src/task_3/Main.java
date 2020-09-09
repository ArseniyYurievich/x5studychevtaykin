package task_3;

public class Main {
    public static void main(String[] args) {
        Student aspirant = new Aspirant("Полуэкт", "Полуэктович", "аспиранты", 4.5d, "важное");
        Student[] students = {aspirant,
                new Student("Сигизмунд", "Вассисуариевич", "студенты", 5d),
                new Aspirant("Модест", "Карлович", "аспиранты", 5d, "не очень"),
                new Student("Сыктыфкар", "Мадридович", "студенты", 4d)};
        for (Student student :
                students) {
            System.out.printf("%s, стипендия: %d%n", student.getFullName(), student.getScholarship());
        }
    }
}
