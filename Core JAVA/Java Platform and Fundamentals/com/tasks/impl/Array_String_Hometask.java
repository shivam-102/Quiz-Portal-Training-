package com.tasks.impl;
import java.util.Scanner;
public class Array_String_Hometask {
    //Question-1
    public static void MissingNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int arraySize = scanner.nextInt();
        int array[] = new int[arraySize];
        System.out.println("Enter values in array");

        for (int initialize = 0; initialize < arraySize; initialize++) {
            array[initialize] = scanner.nextInt();
        }
        int sum = ((arraySize + 1) * (arraySize + 2)) / 2; //formula for sum of n elements -> n*(n+1)/2
        for (int initialize = 0; initialize < arraySize; initialize++) {
            sum = sum - array[initialize];
        }
        System.out.println("The missing number is : " + sum);
    }
    //Question-2
    public static void BiggestSmallestNumber(){

        int big=Integer.MIN_VALUE, small=Integer.MAX_VALUE;
        System.out.println("Enter size of array");
        Scanner scanner=new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int arr[] = new int[arraySize];
        System.out.println("Enter values in array");
        for (int initialize = 0; initialize< arraySize; initialize++) {
            arr[initialize] = scanner.nextInt();
            if(arr[initialize]>=big) {
                big=arr[initialize];
            }
            if(arr[initialize]<=small) {
                small=arr[initialize];
            }
        }
        System.out.println("Biggest Number : "+big);
        System.out.println("Smallest Number : "+small);
    }

    //Question-3
    public static void DuplicateCharacters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = scanner.nextLine();
        int counter=0;
        char charArray[] = input.toCharArray();
        System.out.println("The duplicate characters are : ");
        for(int initialize = 0; initialize <charArray.length; initialize++) {
            counter = 1;
            for(int initialize2 = initialize+1; initialize2 <charArray.length; initialize2++) {
                if(charArray[initialize] == charArray[initialize2] && charArray[initialize] != ' ') {
                    counter++;
                    charArray[initialize2] = '0';
                }
            }
            if(counter > 1 && charArray[initialize] != '0') {
                System.out.println(charArray[initialize]);
            }
        }
    }


    //Question-4
    public static boolean rotationResult(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        String temp = string1 + string2;
        if (temp.indexOf(string2) != -1) {return true;}
        else {return false;}
    }
    public static void main(String[] args) {
        //Question-1
        Array_String_Hometask.MissingNumber();
        //Question-2
        Array_String_Hometask.BiggestSmallestNumber();
        //Question-3
        Array_String_Hometask.DuplicateCharacters();
        //Question-4
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings");
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        if (rotationResult(input1, input2)) {
            System.out.println("The given strings are rotations of each other");
        } else {
            System.out.println("The given strings are not rotations of each other");
        }


    }

}
