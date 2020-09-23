package task_1;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return 2.0d * Math.PI * Math.pow(radius, 2);
    }
}
