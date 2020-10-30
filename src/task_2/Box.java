package task_2;

import task_1.LinkedListCollection;

public class Box<T extends Fruit> {
    private final LinkedListCollection<T> fruits = new LinkedListCollection<>();

    public void add(T fruit) {
        try {
            fruits.add(fruit);
        } catch (Exception e) {
            System.out.println("Ошибка: не удалось добавить фрукт.\n");
            e.printStackTrace();
        }
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
    }

    public double getWeight() {
        double weight = 0d;
        for (int i = 0; i < fruits.size(); i++) {
            weight += fruits.get(i).getWeight();
        }
        return weight;
    }

    public Fruit get(int index) {
        return fruits.get(index);
    }

    public void setFruitsQty(int qty) {
        if (fruits.size() == 0) {
            System.out.println("Ошибка. Невозможно установить количество в пустой коробке");
            return;
        }

        while (fruits.size() < qty) {
            fruits.add(fruits.get(0));
        }
        while (fruits.size() > qty) {
            fruits.remove(fruits.get(0));
        }
    }

    public boolean compare(Box<T> box) {
        return this.getWeight() == box.getWeight();
    }

    public void setFruitsWeight(float singleFruitWeight) {
        for (int i = 0; i < fruits.size(); i++) {
            fruits.get(i).setWeight(singleFruitWeight);
        }
    }

    public void moveFruits(Box<T> destination) {
        if (destination.getClass() != this.getClass()) {
            System.out.println("Ошибка. Допускается объединять только фрукты одинаковых типов");
            return;
        }
        for (int i = 0; i < fruits.size(); i++) {
            destination.fruits.add(this.fruits.get(i));
        }
        fruits.clear();
    }
}
