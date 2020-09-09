package task_2;

public abstract class Animal {
    private String food;
    private String location;
    protected boolean isSleeping;
    protected boolean isEating;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public abstract void makeNoise();

    public void eat() {
        isSleeping = false;
        isEating = true;
    }

    public void sleep() {
        isEating = false;
        isSleeping = true;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
