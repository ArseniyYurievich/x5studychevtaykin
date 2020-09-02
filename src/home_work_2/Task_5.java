package home_work_2;

import java.util.Arrays;
import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            if (scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            } else {
                System.out.println(Common.INVALID_NUMBER_MESSAGE);
                System.exit(1);
            }
        }
        Arrays.sort(array);
        System.out.println("Наименьшее из введённых чисел: " + array[0]);
    }
}
