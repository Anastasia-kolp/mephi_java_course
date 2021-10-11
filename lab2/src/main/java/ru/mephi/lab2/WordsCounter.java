package ru.mephi.lab2;

import java.util.HashMap;
import java.util.Scanner;

class WordsCounter {
    public static void main(String[] args) {
        System.out.print("Enter the string >>> ");
        Scanner input = new Scanner(System.in);
        String[] counter = input.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String str : counter) {
            Object value = map.get(str);
            map.put(str, (value == null) ? 1 : ((int) value + 1));
        }
        for (HashMap.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
