package task_1;

public class Calculator {
    private final Logger logger;

    public Calculator(Logger logger) {
        this.logger = logger;
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
