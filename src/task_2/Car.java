package task_2;

public abstract class Car {
    private final String mark;
    private final String carClass;
    private final int weight;
    private final Engine engine;

    public abstract void start();
    public abstract void stop();

    public Car(String mark, String carClass, int weight, Engine engine) {
        this.mark = mark;
        this.carClass = carClass;
        this.weight = weight;
        this.engine = engine;
    }

    public void printInfo() {
        System.out.printf("Марка: %s, класс: %s, вес: %d, двигатель: %s%n", mark, carClass, weight, engine);
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }
}
