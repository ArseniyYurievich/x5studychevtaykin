package task_1;

public class ArrayCollection<E> {
    private E[] array;
    private int size;
    private int capacity;

    public ArrayCollection(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayCollection() {
        this.capacity = 100;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E item) {
        // если массив заполнен полностью то необходимо его расширить
        if (size == capacity) {
            // увеличиваем размер на половину актуального размера
            capacity = (int) Math.round(1.5 * capacity);
            E[] tempArray = (E[]) new Object[capacity];
            System.arraycopy(array, 0, tempArray, 0, size - 1);
            array = tempArray;
        }
        array[size++] = item;
    }

    public void remove(int index) {
        if (checkIndexBounds(index)) {
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
    }

    public void remove(E item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                remove(i);
                return;
            }
        }
    }

    public E get(int index) {
        if (checkIndexBounds(index)) {
            return array[index];
        } else {
            return null;
        }
    }

    public void clear() {
        array = (E[]) new Object[capacity];
        size = 0;
    }

    private boolean checkIndexBounds(int index) {
        return index >= 0 && index < size;
    }

}
