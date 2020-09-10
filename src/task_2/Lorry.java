package task_2;

public class Lorry extends Car {
    public static final String CAR_CLASS = "грузовик";
    private final float liftingCapacity;

    public Lorry(String mark, int weight, Engine engine, float liftingCapacity) {
        super(mark, CAR_CLASS, weight, engine);
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public void start() {
        System.out.println("Грузовик поехал");
    }

    @Override
    public void stop() {
        System.out.println("грузовик остановился");
    }

    public float getLiftingCapacity() {
        return liftingCapacity;
    }
}
