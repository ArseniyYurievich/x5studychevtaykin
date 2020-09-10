package task_2;

public class SportCar extends Car {
    public static final String CAR_CLASS = "спортивный";
    private int maxSpeed;

    public SportCar(String mark, int weight, Engine engine, int maxSpeed) {
        super(mark, CAR_CLASS, weight, engine);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void start() {
        System.out.println("SportCar поехал");
    }

    @Override
    public void stop() {
        System.out.println("SportCar остановился");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
