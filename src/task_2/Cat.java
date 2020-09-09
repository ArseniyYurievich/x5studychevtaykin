package task_2;

public class Cat extends Animal {
    private final float wallClimbingHeight;

    @Override
    public void eat() {
        super.eat();
        System.out.println("мяу");
    }

    public Cat(String food, String location, float wallClimbingHeight) {
        super(food, location);
        this.wallClimbingHeight = wallClimbingHeight;
    }

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
        System.out.printf("%s %s %n", "кот", action);
    }

    public float getWallClimbingHeight() {
        return wallClimbingHeight;
    }
}
