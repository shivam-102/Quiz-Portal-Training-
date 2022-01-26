package com.collection.task;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

class Printer {

    public static void printArray(Object[] obj){
        System.out.println(Arrays.toString(obj));
    }

}
public class Hometask6_6 {
    public static void main(String args[]){
        Printer arr = new Printer ();
        // create arrays of Integer, Double and Character
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
        System.out.println("Array integerArray contains:");
        Printer.printArray(integerArray); // pass an Integer array
        System.out.println("\nArray doubleArray contains:");
        Printer.printArray(doubleArray); // pass a Double array
        System.out.println("\nArray characterArray contains:");
        Printer.printArray(characterArray); // pass a Character array
    }
}

