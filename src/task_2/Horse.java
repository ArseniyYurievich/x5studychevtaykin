package task_2;

public class Horse extends Animal {
    private final float hooveSize;

    public Horse(String food, String location, float hooveSize) {
        super(food, location);
        this.hooveSize = hooveSize;
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
        System.out.printf("%s %s %n", "конь", action);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("цок");
    }

    public float getHooveSize() {
        return hooveSize;
    }
}
