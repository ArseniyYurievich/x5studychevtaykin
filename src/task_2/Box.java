package task_2;

import task_1.LinkedListCollection;

public class Box<T extends Fruit> {
    private final LinkedListCollection<T> fruits = new LinkedListCollection<>();

    public boolean canInsert(Fruit fruit) {
        if (fruits.size() == 0) {
            return true;
        }
        return fruit.getClass() == fruits.get(0).getClass();
    }

    public void add(T fruit) {
        if (canInsert(fruit)) {
            fruits.add(fruit);
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
        if (destination.fruits.size() > 0 && !canInsert(destination.get(0))) {
            System.out.println("Ошибка. Допускается объединять только фрукты одинаковых типов");
            return;
        }
        for (int i = 0; i < fruits.size(); i++) {
            destination.fruits.add(this.fruits.get(i));
        }
        fruits.clear();
    }
}
