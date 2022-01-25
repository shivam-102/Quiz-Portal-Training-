package com.tasks.impl;

import java.util.Scanner;

public class Java_Language_Construct_Hometask {
    //declared this as static so that there would need to keep a object
    //Question-1
    public static int caughtSpeeding(int speed, boolean isBirthday) {
        if(isBirthday==true){speed-=5;}
        if(speed<=60){return 0;}
        else if(speed>60 && speed <=80){return 1;}
        else if(speed>80){return 2;}
        else{return -1;}
    }

    //Question-2
    public static boolean truelyGreatNumber(int a,int b){
        if((a==6)||(b==6)||(a+b==6)||(a-b==6))
            return true;
        else
            return false;


    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //Question 1
        System.out.println("Enter your speed");
        int speed=sc.nextInt();
        System.out.println("Is it your birthday?(true/false)");
        boolean isBirthday = sc.nextBoolean();
        System.out.println(Java_Language_Construct_Hometask.caughtSpeeding(speed,isBirthday));

        //Question 2 - Truely great Number
        System.out.println("Enter a");
        int a=sc.nextInt();
        System.out.println("Enter b");
        int b=sc.nextInt();
        System.out.println(Java_Language_Construct_Hometask.truelyGreatNumber(Math.abs(a),Math.abs(b)));

        //Question 3
        










    }

}
