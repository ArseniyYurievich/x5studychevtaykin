package home_work_2;

import java.util.Arrays;

public class Task_9 {

    public static void main(String[] args) {
        int[] input = {15, 10, 51, -6, -5, 3, -10, -34, 0, 32, 56, -12, 24, -52};

        for (int i = 0, temp, length = input.length; i < length / 2; i++) {
            temp = input[i];
            input[i] = input[input.length - i - 1];
            input[length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(input));
    }
}
