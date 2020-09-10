package task_1;

public class Rectangle implements Shape {
    private double base;
    private double height;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double square() {
        return base * height;
    }
}
