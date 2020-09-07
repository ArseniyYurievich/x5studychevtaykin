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
            i = Math.abs(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return i >= 100 && i <= 999;
    }

    private static int sumDigits(String input) {
        int sum = 0;
        boolean isNumberPositive = Integer.parseInt(input) >= 0;
        // для отрицательных чисел суммируем начиная со второго символа
        for (int i = isNumberPositive ? 0 : 1; i < input.length(); i++) {
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return sum;
    }
}
