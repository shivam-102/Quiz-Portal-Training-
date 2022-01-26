package com.tasks.impl;
import java.util.Scanner;
public class Array_String_Hometask {
    //Question-1
    public static void MissingNumber(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array");
        int arraySize = in.nextInt();
        int arr[] = new int[arraySize];
        System.out.println("Enter values in array");
        for (int i = 0; i < arraySize; i++) {
            arr[i] = in.nextInt();
        }
        int sum = ((arraySize + 1) * (arraySize + 2)) / 2; //formula for sum of n elements -> n*(n+1)/2
        for (int i = 0; i < arraySize; i++) {
            sum = sum - arr[i];
        }
        System.out.println("The missing number is : " + sum);
    }
    //Question-2
    public static void BiggestSmallestNumber(){
        Scanner in = new Scanner(System.in);
        int big=Integer.MIN_VALUE, small=Integer.MAX_VALUE;
        System.out.println("Enter size of array");
        int arraySize = in.nextInt();
        int arr[] = new int[arraySize];
        System.out.println("Enter values in array");
        for (int i = 0; i < arraySize; i++) {
            arr[i] = in.nextInt();
            if(arr[i]>=big) {
                big=arr[i];
            }
            if(arr[i]<=small) {
                small=arr[i];
            }
        }
        System.out.println("Biggest Number : "+big);
        System.out.println("Smallest Number : "+small);
    }

    //Question-3
    public static void DuplicateCharacters(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = in.nextLine();
        int ctr=0;
        char charArr[] = input.toCharArray();
        System.out.println("The duplicate characters are : ");
        for(int i = 0; i <charArr.length; i++) {
            ctr = 1;
            for(int j = i+1; j <charArr.length; j++) {
                if(charArr[i] == charArr[j] && charArr[i] != ' ') {
                    ctr++;
                    charArr[j] = '0';
                }
            }
            if(ctr > 1 && charArr[i] != '0') {
                System.out.println(charArr[i]);
            }
        }
    }


    //Question-4
    public static boolean rotationResult(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String temp = str1 + str1;
        if (temp.indexOf(str2) != -1) {
            return true;
        } else {
            return false;
        }
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
