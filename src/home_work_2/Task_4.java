package home_work_2;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            System.out.println(parseInput(scanner.nextInt()));
        } else {
            System.out.println(Common.INVALID_NUMBER_MESSAGE);
        }
    }

    private static int parseInput(int input) {
        if (input > 0) {
            return ++input;
        } else if (input < 0) {
            return input - 2;
        } else {
            return 10;
        }
    }
}
