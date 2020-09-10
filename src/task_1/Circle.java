package task_1;

public class Circle implements Shape {
    @Override
    public double square() {
        return 2.0d * Math.PI * Math.pow(radius, 2);
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    private float radius;
}
