package home_work_2;

import java.util.Arrays;

public class Task_10 {
    public static void main(String[] args) {
        int[] array = {15,10,0,-6,-5,3,0,-34,0,32,56,0,24,-52};
        int lastNotZeroIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[lastNotZeroIndex++] = array[i];
            }
        }
        for (int i = lastNotZeroIndex; i < array.length; i++) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }
}
