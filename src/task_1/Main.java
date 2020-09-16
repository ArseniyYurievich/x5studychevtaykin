package task_1;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.printf("%.2f %s %.2f равно %.2f%n", 1d, "плюс", 2d, calculator.add(1, 2));
        System.out.printf("%.2f %s %.2f равно %.2f%n", 1d, "минус", 2d, calculator.subtract(1, 2));
        System.out.printf("%.2f %s на %.2f равно %.2f%n", 1d, "умножить", 2d, calculator.multiply(1, 2));
        System.out.printf("%.2f %s на %.2f равно %.2f%n", 1d, "разделить", 2d, calculator.divide(1, 2));
    }
}
