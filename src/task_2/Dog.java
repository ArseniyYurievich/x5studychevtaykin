package task_2;

public class Dog extends Animal {
    private final float carSprintLength;

    @Override
    public void makeNoise() {
        String action;
        if (isEating) {
            action = "ест";
        } else if (isSleeping) {
            action = "спит";
        } else {
            action = "шумит";
        }
        System.out.printf("%s %s %n", "пёс", action);
    }

    public Dog(String food, String location, float carSprintLength) {
        super(food, location);
        this.carSprintLength = carSprintLength;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("гав");
    }
}
