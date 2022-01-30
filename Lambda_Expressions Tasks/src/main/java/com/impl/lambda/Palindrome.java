package com.impl.lambda;
import java.util.Scanner;
import java.util.function.Consumer;
public class Palindrome {
    static boolean isPalindrome(String string){
        int pointer1=0;
        int pointer2=string.length()-1;
        while(pointer1<pointer2){
            if(string.charAt(pointer1)!=string.charAt(pointer2)){
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the string which you want to check whether it is palindrome or not:");
        String input=scanner.nextLine();
        //using Lambda function and consumer functional interface

        Consumer<String> consumer=(string) ->{
            String reverse="";
            for(int initializingVar=string.length()-1;initializingVar>=0;initializingVar--){
                reverse=reverse+string.charAt(initializingVar);
            }
            if(reverse.equals(string)){
                System.out.println(string+" "+"is a palindrome");
            }
            else{
                System.out.println(string+" "+"is not a palindrome");
            }
        };
        consumer.accept(input);



        //without using lambda expressions
        System.out.println(Palindrome.isPalindrome(input));

    }
}
