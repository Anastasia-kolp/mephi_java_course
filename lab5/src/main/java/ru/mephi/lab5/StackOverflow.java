package ru.mephi.lab5;

public class StackOverflow {
    public static void recursive(){
        recursive();
    }

    public static void main(String[] args) {
        try{
            recursive();
        }catch (StackOverflowError err){
            System.out.println(err);
        }
    }
}
