package task_1;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Triangle(1, 2);
        shape[1] = new Circle(3);
        shape[2] = new Rectangle(4, 5);
        for (Shape sh : shape) {
            System.out.println("Площадь фигуры: " + sh.square());
        }
    }
}
