package task_1;

import java.util.Scanner;

public class Calculator {
    private final Logger logger;

    {
        System.out.println("Выберите метод логирования (Console, File, DB):");
        logger = getLogger(new Scanner(System.in).next());
    }

    private Logger getLogger(String type) {
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

    public double add(double first, double second) {
        logger.log("сложение");
        return first + second;
    }

    public double subtract(double first, double second) {
        logger.log("вычитание");
        return first - second;
    }

    public double multiply(double first, double second) {
        logger.log("умножение");
        return first * second;
    }

    public double divide(double first, double second) {
        if (second == 0d) {
            logger.log("деление на ноль");
            return 0d;
        } else {
            logger.log("деление");
            return first / second;
        }
    }
}
