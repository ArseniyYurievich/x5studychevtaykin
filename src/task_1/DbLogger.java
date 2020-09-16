package task_1;

public class DbLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.printf("Log into database: %s%n", message);
    }
}
