package task_1;

public class LoggerFactory {
    private LoggerFactory(){}

    public static Logger getLogger(String type) {
        switch (type) {
            case "Console":
                return new ConsoleLogger();
            case "File":
                return new FileLogger();
            case "DB":
                return new DbLogger();
            default: {
                System.out.println("Введён неизвестный метод. Будет выбран метод по умолчанию - Console");
                return new ConsoleLogger();
            }
        }
    }
}
