package ru.mephi.lab1;

import java.util.Arrays;

class List {
    private Object[] value;
    private int size;
    private static final int CONTAINER_SIZE = 8;

    List() {
        this.size = 0;
        this.value = new Object[CONTAINER_SIZE];
    }

    List(Object... copying) {
        if (copying != null) {
            this.size = copying.length;
            int realSize = CONTAINER_SIZE * ((copying.length / CONTAINER_SIZE) + 1);
            this.value = new Object[realSize];
            System.arraycopy(copying, 0, value, 0, size);
            smallCapacity();
        } else {
            this.size = 0;
            this.value = new Object[CONTAINER_SIZE];
        }
    }

    private void largeCapacity() {
        if (size % CONTAINER_SIZE == 0) {
            Object[] copying = new Object[size + CONTAINER_SIZE];
            System.arraycopy(value, 0, copying, 0, size);
            //size = size + CONTAINER_SIZE;
            value = new Object[size + CONTAINER_SIZE];
            System.arraycopy(copying, 0, value, 0, size + CONTAINER_SIZE);
        }
    }

    private void smallCapacity() {
        if (size % CONTAINER_SIZE == 0) {
            Object[] copying = new Object[size];
            System.arraycopy(value, 0, copying, 0, size);
            value = new Object[size];
            System.arraycopy(copying, 0, value, 0, size);
        }
    }

    public void add(Object value) {
        if (value == null) {
            System.out.println("Not null value!");
            return;
        }
        largeCapacity();
        this.value[size] = value;
        size++;
    }

    public Object remove(int index) {
        if (index >= size || index < 0)
            return null;
        Object returning = this.value[index];
        for (int i = index; i < size - 1; i++) {
            value[i] = value[i + 1];
        }
        value[size - 1] = null;
        /*Object[] result = new Object[size - 1];
        System.arraycopy(this.value, 0, result, 0, size - 1);*/
        this.size--;
        smallCapacity();
        return returning;
    }

    public void add(Object adding, int index) {
        if (adding == null) {
            System.out.println("Not null value!");
            return;
        }
        if (index > size) {
            System.err.println("The index must be less than or equal to the size of the list.");
            return;
        }
        if (index == size) {
            add(adding);
        } else {
            largeCapacity();
            Object[] result = new Object[size - index];
            System.arraycopy(this.value, index, result, 0, size - index);
            value[index] = adding;
            System.arraycopy(result, 0, value, index + 1, size - index);
            size++;
        }
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            return this.value[index];
        }
    }

    public int indexOf(Object value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.value[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(Object value) {
        if (value == null) {
            System.out.println("Not null value!");
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.value[i] == value)
                return true;
        }
        return false;
    }

    public Object set(Object value, int index) {
        if (index >= size || index < 0 || value == null)
            return null;
        Object ret = this.value[index];
        this.value[index] = value;
        return ret;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "List{" +
                "value=" + Arrays.toString(value) +
                ", size=" + size +
                '}';
    }

    /*public void print() {
        System.out.println("=====================================================");
        for (int i = 0; i < size; i++) {
            System.out.println(value[i]);
        }
        System.out.println("=====================================================");
    }*/

    public static void main(String[] args) {
        List list = new List(5, 6, 7, 10, 12);
        System.out.println(list);
        System.out.println(list.getSize());
        list.remove(2);
        System.out.println(list);
        System.out.println(list.getSize());
        list.add(68);
        list.add(54, 3);
        list.add(6);
        list.add(79);
        list.add(67);
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println(list.contains(12));
        System.out.println(list.contains(7));
    }
}
