package task_1;

public class Triangle implements Shape {
    private double base;
    private double height;

    @Override
    public double square() {
        return 0.5d * base * height;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
}
