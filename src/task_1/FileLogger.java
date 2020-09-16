package task_1;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.printf("Log into file: %s%n", message);
    }
}
