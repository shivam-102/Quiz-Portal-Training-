package com.tasks.impl;
import java.util.Scanner;
public class Variables {

    static int danielvar,ambervar;
    static double danieldouble,amberdouble;
    Variables(int daniel,int amber){
        danielvar=daniel;
        ambervar=amber;
    }
    Variables(double daniel,double amber){
        danieldouble=daniel;
        amberdouble= amber;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        new Variables(scanner.nextInt(),scanner.nextInt());
        new Variables(scanner.nextDouble(), scanner.nextDouble());
        //for integer sum
        System.out.println("The total number of apples of Daniel and Amber = "+(Variables.danielvar+Variables.ambervar));
        //for double sum
        System.out.println("The total number of apples of Daniel and Amber = "+(Variables.danieldouble+Variables.amberdouble));
        }
}
