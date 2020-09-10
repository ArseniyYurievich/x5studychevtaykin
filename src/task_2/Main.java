package task_2;

public class Main {
    public static void main(String[] args) {
        Car lorry = new Lorry("ГАЗ-3307", 7850,
                new Engine(130, "ГАЗ"), 4500);
        Car sportCar = new SportCar("Marussia B2", 1100,
                new Engine(420, "Nissan"), 250);

        lorry.printInfo();
        sportCar.printInfo();
    }
}
