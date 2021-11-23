package ru.mephi.lab5;

import java.io.*;

public class Exceptions {
    public static void throwArrayIndexOutOfBounds() throws ArrayIndexOutOfBoundsException{
        int array[] = {0, 1, 2};
        int example = array[5]; //ArrayIndexOutOfBoundsException
    }

    public static void throwFileNotFound() throws FileNotFoundException {
        FileReader example = new FileReader("example.txt"); //FileNotFoundException
    }

    public static void throwNullPointer() throws NullPointerException{
        Object example = null;
        example.hashCode(); //NullPointerException
    }

    public static void throwIO() throws IOException {
        File file = new File("test.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.close();
        writer.write("Hello!"); //IOException
    }

    public static void throwClassCast() throws ClassCastException{
        Object example = Integer.valueOf(100);
        String s = (String)example; //ClassCastException
    }

    public static void throwArithmetic() throws ArithmeticException{
        int divide = 100 / 0; //ArithmeticException
    }

    public static void main(String[] args) {
        try{
            throwArrayIndexOutOfBounds();
        } catch(ArrayIndexOutOfBoundsException err){
            System.out.println(err.getMessage());
        }

        try {
            throwFileNotFound();
        } catch(FileNotFoundException err){
            System.out.println(err.getMessage());
        }

        try {
            throwNullPointer();
        } catch(NullPointerException err){
            System.out.println(err.getMessage());
        }

        try {
            throwIO();
        } catch (IOException err){
            System.out.println(err.getMessage());
        }

        try {
            throwClassCast();
        } catch(ClassCastException err){
            System.out.println(err.getMessage());
        }

        try {
            throwArithmetic();
        } catch (ArithmeticException err){
            System.out.println(err.getMessage());
        }
    }
}
