package com.tasks.impl;

public class Home_Task_Loops {
    public static void main(String [] args){
        int multiply1=1,number_of_rows=5;
        //task 1 using while loop
        int pointer1=1,pointer2=1,counter=0;
        while(pointer1<=number_of_rows){
            pointer2=1;

            while(pointer2<=pointer1){
                System.out.print(counter*multiply1+" ");
                counter+=1;
                pointer2++;

            }
            System.out.println();
            pointer1++;
        }
        //task 2 using for loop
        counter=0;
        int multiply2=2;
        for(pointer1=1;pointer1<=number_of_rows;pointer1++){
            for(pointer2=1;pointer2<=pointer1;pointer2++){
                System.out.print(counter*multiply2+" ");
                counter++;
            }
            System.out.println();
        }
        //using do-while loop
        int multiply3=3;
        counter=0;
        pointer1=1;
        pointer2=1;
        do{
            pointer2=1;
            do{
                System.out.print(counter*multiply3+" ");
                counter+=1;
                pointer2++;
            }while(pointer2<=pointer1);
            pointer1++;
            System.out.println();
        }while(pointer1<=number_of_rows);
    }
}
