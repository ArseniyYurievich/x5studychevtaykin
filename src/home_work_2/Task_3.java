package home_work_2;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        System.out.println(parseInput(input));
    }

    private static String parseInput(String input) {
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return Common.INVALID_NUMBER_MESSAGE;
        }

        return String.valueOf(i > 0 ? ++i : i);
    }
}
