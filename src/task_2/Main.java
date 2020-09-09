package task_2;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("мыши", "дом", 1.5f)
                , new Dog("всё подряд", "будка", 2.2f)
                , new Horse("овёс", "конюшня", 0.5f)};
        for (Animal animal :
                animals) {
            Veterinarian.treatAnimal(animal);
        }
    }
}
