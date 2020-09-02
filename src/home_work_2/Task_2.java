package home_work_2;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        if (checkInput(input)) {
            System.out.println("Сумма цифр: " + sumDigits(input));
        } else {
            System.out.println(Common.INVALID_NUMBER_MESSAGE);
        }
    }

    private static boolean checkInput(String input) {
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return (float) i / 999 <= 1;
    }

    private static int sumDigits(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return sum;
    }
}
