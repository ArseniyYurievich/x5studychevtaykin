package home_work_2;

public class Task_8 {
    private static final int[] array = {1,-10,5,6,45,23,-45,-34,0,32,56,-1,2,-2};

    public static void main(String[] args) {
        int max = array[0];
        int countPositive = 0;
        int sumPositive = 0;
        int countNegative = 0;
        int sumNegative = 0;
        int sumEvenNegative = 0;

        for (int i: array) {
            max = Math.max(i, max);
            sumPositive += Math.max(i, 0);
            sumEvenNegative += ((i % 2 == 0) && (i < 0)) ? i : 0;
            countPositive += i > 0 ? 1 : 0;
            countNegative += i < 0 ? 1 : 0;
            sumNegative += Math.min(i, 0);
        }
        float averageNegative = countNegative > 0 ? (float) sumNegative / countNegative : 0;

        System.out.println("максимальное значение: " + max);
        System.out.println("сумма положительных элементов: " + sumPositive);
        System.out.println("сумма чётных отрицательных элементов: " + sumEvenNegative);
        System.out.println("количество положительных элементов: " + countPositive);
        System.out.println("среднее арифмитическое отрицательных элементов: " + averageNegative);
    }
}
