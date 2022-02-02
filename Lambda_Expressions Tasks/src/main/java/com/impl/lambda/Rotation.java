package com.impl.lambda;
import java.util.Scanner;
interface Operation{
    boolean result(String stringMain, String stringToMatch);
}
public class Rotation {
    static boolean isRotation(String stringCheck,String stringCheckForRotation){
        if (stringCheck.length() != stringCheckForRotation.length())
            return false;
        String stringNew=stringCheck+stringCheck;
        if(stringNew.indexOf(stringCheckForRotation)!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter string1:");
        String stringMain=scanner.nextLine();
        System.out.println("Enter string2:");
        String stringToMatch=scanner.nextLine();
        //With Lambda Expression
        Operation operation=(stringCheck,stringCheckForRotation)-> {
            if (stringCheck.length() != stringCheckForRotation.length())
                return false;
            String stringNew=stringCheck+stringCheck;
            if(stringNew.indexOf(stringCheckForRotation)!=-1){
                return true;
            }
            else{
                return false;
            }

        };
        System.out.println(operation.result(stringMain,stringToMatch));
        
        //WITHOUT Lambda Interface
        System.out.println(Rotation.isRotation(stringMain,stringToMatch));

    }
}
