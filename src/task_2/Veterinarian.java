package task_2;

public class Veterinarian {
    public static void treatAnimal(Animal animal) {
        System.out.printf("{еда: %s, локация: %s}%n", animal.getFood(), animal.getLocation());
    }
}
