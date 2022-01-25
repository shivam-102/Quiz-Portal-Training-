package com.tasks.impl;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Give two integer inputs");
        int number1=sc.nextInt();
        int number2=sc.nextInt();
        //string required as input for switch case
        System.out.println("Type : add for addition,sub for subtraction, multi for multiplication,div for division, rem_div for remainder division,per for percentage");
        //command line input for switch case key
        String st=args[0];
        switch(st){
            case "add": System.out.println("Result :"+(number1+number2));
            break;
            case "sub": System.out.println("Result :"+(number1-number2));
            break;
            case "multi": System.out.println("Result :"+(number1*number2));
            break;
            case "div" : System.out.println("Result :"+(number1/number2));
            break;
            //additional task
            case "rem div": System.out.println("Result :"+(number1%number2));
            break;
            case "per": System.out.println("Result :"+(((number1-number2)*100)/number1));
                    break;
            default:System.out.println("Not a valid operation");

        }

    }
}
