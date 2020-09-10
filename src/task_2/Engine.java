package task_2;

public class Engine {
    private final int power;
    private final String manufacturer;

    public Engine(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "мощность: " + power
                + ", производитель: " + manufacturer;
    }
}
