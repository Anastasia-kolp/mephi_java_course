package ru.mephi.lab1;

import java.util.Arrays;

class Map {
    private int size;
    private static final int CONTAINER_SIZE = 16;
    private Node[] values;

    Map() {
        this.size = 0;
        this.values = new Node[CONTAINER_SIZE];
    }

    private void largeCapacity() {
        if (size % CONTAINER_SIZE == 0) {
            Node[] copying = new Node[size + CONTAINER_SIZE];
            System.arraycopy(values, 0, copying, 0, size);
            values = new Node[size + CONTAINER_SIZE];
            System.arraycopy(copying, 0, values, 0, size);
        }
    }

    private void smallCapacity() {
        if (size % CONTAINER_SIZE == 0) {
            Node[] copying = new Node[size];
            System.arraycopy(values, 0, copying, 0, size);
            values = new Node[size];
            System.arraycopy(copying, 0, values, 0, size);
        }
    }

    public void put(Object key, Object value) {
        if (key == null || value == null) {
            System.err.println("Null value or key!");
        } else {
            if (size == 0) {
                values[0] = new Node(key, value);
                size++;
            } else {
                if (keyContains(key)) {
                    System.err.println("This key also exist!");
                } else {
                    largeCapacity();
                    values[size] = new Node(key, value);
                    size++;
                }
            }
        }
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key))
                return values[i].getValue();
        }
        return null;
    }

    public Object get(Object key, Object byDefault) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key))
                return values[i].getValue();
        }
        put(key, byDefault);
        return byDefault;
    }

    public Object remove(Object key) {
        Object ret = null;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                ret = values[i].getValue();
                values[i] = null;
                Node[] copying = new Node[size - 1];
                System.arraycopy(values, i + 1, copying, 0, size - i - 1);
                size--;
                System.arraycopy(copying, 0, values, i, size - i);
                smallCapacity();
                break;
            }
        }
        for (int i = size; i < values.length; i++) {
            values[i] = null;
        }
        return ret;
    }

    public boolean keyContains(Object key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key))
                return true;
        }
        return false;
    }

    public List getKeys() {
        Object[] keys = new Object[size];
        for (int i = 0; i < size; i++)
            keys[i] = values[i].getKey();
        return new List(keys);
    }

    public List getValues() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++)
            a[i] = values[i].getValue();
        return new List(a);
    }

    public List getEntries() {
        Node[] entry = new Node[size];
        System.arraycopy(values, 0, entry, 0, size);
        return new List(entry);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Map{" +
                "size=" + size +
                ", values=" + Arrays.toString(values) +
                '}';
    }

    /*@Override
    public String toString(){
        System.out.println("=====================================================");
        for(int i = 0; i < size; i++){
            System.out.println("Key: " + values[i].getKey() + " Value: " + values[i].getValue());
        }
        System.out.println("=====================================================");
    }*/

    public static void main(String[] args) {
        Map mymap = new Map();
        System.out.println("Size: " + mymap.size());
        mymap.put(10, "Apple");
        mymap.put(1, "Orange");
        mymap.put(79, "Grape");
        mymap.put("Lemon", 80);
        System.out.println(mymap);
        List list = mymap.getKeys();
        System.out.println(list);
        List list1 = mymap.getValues();
        System.out.println(list1);
        List list2 = mymap.getEntries();
        System.out.println(list2);
        System.out.println("Val at 79 " + mymap.get(79));
        System.out.println("Val at 1 " + mymap.get(1));
        System.out.println("Val at 10 " + mymap.get(10));
        System.out.println("Val at 2 " + mymap.get(2));
        mymap.put(null, "Pear");
        System.out.println("Val at null " + mymap.get(null));
        System.out.println("Map has key at null:" + mymap.keyContains(null));
        System.out.println("Map has key at lemon:" + mymap.keyContains("Lemon"));
        System.out.println("Size of Map:" + mymap.size());
        System.out.println(mymap.remove(1));
        System.out.println(mymap);
        System.out.println("Map has key at 1:" + mymap.keyContains(1));
        System.out.println("Size of Map:" + mymap.size());
        mymap.get(79, "Pineapple");
        System.out.println(mymap);
        mymap.get(7, "Pineapple");
        System.out.println(mymap);
    }
}