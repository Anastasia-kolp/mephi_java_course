package ru.mephi.lab5;

public class OutOfMemory {
    public static void main(String[] args) {
        try {
            int value = 10;
            for (int i = 0; i < 100; i++) {
                int[] a = new int[value];
                value = value * 10;
            }
        } catch (OutOfMemoryError err) {
            System.out.println(err.getMessage());
        }
    }
}
