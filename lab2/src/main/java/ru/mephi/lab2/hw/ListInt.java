package ru.mephi.lab2.hw;

import java.util.Arrays;

public class ListInt {
    private int[] value;
    private int size;
    private static final int CONTAINER_SIZE = 8;

    ListInt() {
        this.size = 0;
        this.value = new int[CONTAINER_SIZE];
    }

    ListInt(int... copying) {
        if (copying != null) {
            this.size = copying.length;
            int realSize = CONTAINER_SIZE * ((copying.length / CONTAINER_SIZE) + 1);
            this.value = new int[realSize];
            System.arraycopy(copying, 0, value, 0, size);
            smallCapacity();
        } else {
            this.size = 0;
            this.value = new int[CONTAINER_SIZE];
        }
    }

    private void largeCapacity() {
        if (size % CONTAINER_SIZE == 0) {
            int[] copying = new int[size + CONTAINER_SIZE];
            System.arraycopy(value, 0, copying, 0, size);
            //size = size + CONTAINER_SIZE;
            value = new int[size + CONTAINER_SIZE];
            System.arraycopy(copying, 0, value, 0, size + CONTAINER_SIZE);
        }
    }

    private void smallCapacity() {
        if (size % CONTAINER_SIZE == 0) {
            int[] copying = new int[size];
            System.arraycopy(value, 0, copying, 0, size);
            value = new int[size];
            System.arraycopy(copying, 0, value, 0, size);
        }
    }

    public void add(int value) {
        /*if (value == null) {
            System.out.println("Not null value!");
            return;
        }*/
        largeCapacity();
        this.value[size] = value;
        size++;
    }

    public int remove(int index) {
        if (index >= size || index < 0)
            return -1;
        int returning = this.value[index];
        for (int i = index; i < size - 1; i++) {
            value[i] = value[i + 1];
        }
        value[size - 1] = 0;
        /*Object[] result = new Object[size - 1];
        System.arraycopy(this.value, 0, result, 0, size - 1);*/
        this.size--;
        smallCapacity();
        return returning;
    }

    public void add(int adding, int index) {
        /*if (adding == null) {
            System.out.println("Not null value!");
            return;
        }*/
        if (index > size) {
            System.err.println("The index must be less than or equal to the size of the list.");
            return;
        }
        if (index == size) {
            add(adding);
        } else {
            largeCapacity();
            int[] result = new int[size - index];
            System.arraycopy(this.value, index, result, 0, size - index);
            value[index] = adding;
            System.arraycopy(result, 0, value, index + 1, size - index);
            size++;
        }
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        } else {
            return this.value[index];
        }
    }

    public int indexOf(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.value[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(int value) {
        /*if (value == null) {
            System.out.println("Not null value!");
            return false;
        }*/
        for (int i = 0; i < size; i++) {
            if (this.value[i] == value)
                return true;
        }
        return false;
    }

    public int set(int value, int index) {
        if (index >= size || index < 0)
            return -1;
        int ret = this.value[index];
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
        String result = " ";
        for (int i = 0; i < size; i++)
            result += (value[i] + " ");
        return result.trim();
    }
}
