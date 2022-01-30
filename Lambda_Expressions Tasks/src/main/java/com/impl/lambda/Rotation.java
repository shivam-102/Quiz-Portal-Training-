package com.impl.lambda;

import java.util.Scanner;

interface Operation{
    boolean result(String string1, String string2);
}
public class Rotation {
    static boolean isRotation(String string3,String string4){
        if (string3.length() != string4.length())
            return false;
        String stringx=string3+string3;
        if(stringx.indexOf(string4)!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter string1:");
        String string1=scanner.nextLine();
        System.out.println("Enter string2:");
        String string2=scanner.nextLine();
        /*
        Operation operation=(string3,string4)-> {
            if (string3.length() != string4.length())
                return false;
            String stringx=string3+string3;
            if(stringx.indexOf(string4)!=-1){
                return true;
            }
            else{
                return false;
            }

        };
        System.out.println(operation.result(string1,string2));
        */
        //WITHOUT Lambda Interface
        System.out.println(Rotation.isRotation(string1,string2));

    }
}
