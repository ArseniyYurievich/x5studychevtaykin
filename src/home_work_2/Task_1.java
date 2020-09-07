package home_work_2;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            String string = String.valueOf(scanner.nextInt());
            System.out.println("Последняя цифра: " + string.charAt(string.length() - 1));
        } else {
            System.out.println(Common.INVALID_NUMBER_MESSAGE);
        }
    }
}
