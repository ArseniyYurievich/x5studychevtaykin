package home_work_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_7 {
    private static final String OUTPUT_FORMAT = "%s. Стоимость разговора: %.2f";
    private static final int MINUTES = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            try {
                int cityCode = scanner.nextInt();
                System.out.printf(OUTPUT_FORMAT, CallCost.getCity(cityCode), CallCost.calculate(cityCode, MINUTES));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(Common.INVALID_NUMBER_MESSAGE);
        }
    }

}

class CallCost {
    private static final String ILLEGAL_CITY_CODE = "Неизвестный код города";
    private static Map<Integer, CallCost> map = new HashMap<>();
    private String city;
    private float cost;

    static {
        map.put(905, new CallCost("Москва", 4.15f));
        map.put(194, new CallCost("Ростов", 1.98f));
        map.put(491, new CallCost("Краснодар", 2.69f));
        map.put(800, new CallCost("Киров", 5.00f));
    }

    public CallCost(String city, float cost) {
        this.city = city;
        this.cost = cost;
    }

    public static String getCity(int code) {
        if (CallCost.map.containsKey(code)) {
            return map.get(code).city;
        } else {
            throw new IllegalArgumentException(ILLEGAL_CITY_CODE);
        }
    }

    static float calculate(int cityCode, int minutes) {
        if (CallCost.map.containsKey(cityCode)) {
            return CallCost.map.get(cityCode).cost * minutes;
        } else {
            throw new IllegalArgumentException(ILLEGAL_CITY_CODE);
        }
    }
}