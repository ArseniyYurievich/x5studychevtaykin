package home_work_2;

import java.util.Scanner;

public class Task_7 {
    private static final String OUTPUT_FORMAT = "%s. Стоимость разговора: %.2f";
    private static final int MINUTES = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int cityCode = scanner.nextInt();
            System.out.printf(OUTPUT_FORMAT, getCity(cityCode), calculate(cityCode, MINUTES));
        } else {
            System.out.println(Common.INVALID_NUMBER_MESSAGE);
        }
    }

    public static String getCity(int code) {
        switch (code) {
            case 905:
                return "Москва";
            case 194:
                return "Ростов";
            case 491:
                return "Краснодар";
            case 800:
                return "Киров";
            default:
                return "Неизвестный город";
        }
    }

    public static float getPrice(int code) {
        switch (code) {
            case 905:
                return 4.15f;
            case 194:
                return 1.98f;
            case 491:
                return 2.69f;
            case 800:
                return 5.00f;
            default:
                return 0f;
        }
    }

    static float calculate(int cityCode, int minutes) {
        return (float) minutes * getPrice(cityCode);
    }
}