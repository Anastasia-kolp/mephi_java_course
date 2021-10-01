package ru.mephi.lab1;

class Node {
    private Object key;
    private Object value;

    Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String str = "Key: " + key + " Value: " + value;
        return str;
    }
}

