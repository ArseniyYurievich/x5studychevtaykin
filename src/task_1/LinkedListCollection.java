package task_1;

public class LinkedListCollection<E> {
    private class Item<T extends E> {
        final T value;
        Item<T> previous;
        Item<T> next;


        public Item(T value, Item<T> previous, Item<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Item<E> first;
    private Item<E> last;
    private int size;

    public LinkedListCollection() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E value) {
        Item item = new Item(value, null, null);
        if (size == 0) {
            first = item;
            last = item;
        } else {
            last.next = item;
            item.previous = last;
            last = item;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (size == 1) {
            first = null;
        } else if (index == 0) {
            first = first.next;
            first.previous = null;
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
        } else {
            Item<E> temp = first;
            // устанавливаем temp на удаляемом элементе
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Item<E> previous = temp.previous;
            Item<E> next = temp.next;
            previous.next = next;
            next.previous = previous;
            if (previous.previous == null) {
                first = previous;
            }
            if (next.next == null) {
                last = next;
            }
        }
        size--;
    }

    public void remove(E value) {
        Item<E> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.value.equals(value)) {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                return;
            }
            temp = temp.next;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Item<E> result = first;
        if (index < Math.round((float) size / 2f)) {
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = last;
            for (int i = size - 1; i > index; i--) {
                result = result.previous;
            }
        }
        return result.value;
    }

    public void clear() {
        if (size > 1) {
            while (first.next != null) {
                first = first.next;
            }
        }
        first = null;
        size = 0;
    }
}
