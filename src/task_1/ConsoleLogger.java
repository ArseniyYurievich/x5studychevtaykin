package task_1;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.printf("Log into console: %s%n", message);
    }
}
