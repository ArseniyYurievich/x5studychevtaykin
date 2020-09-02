package home_work_2;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            System.out.println(describeInt(scanner.nextInt()));
        } else {
            System.out.println(Common.INVALID_NUMBER_MESSAGE);
        }
    }

    private static String describeInt(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number > 0) {
            stringBuilder.append("положительное ");
        } else if (number < 0) {
            stringBuilder.append("отрицательное ");
        } else {
            stringBuilder.append("нулевое ");
        }
        if (number != 0) {
            stringBuilder.append(number % 2 == 0 ? "чётное " : "нечётное ");
        }
        return stringBuilder.append("число").toString();
    }
}
