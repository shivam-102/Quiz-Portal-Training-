package com.tasks.impl;

public class Home_Task_Loops {
    public static void main(String [] args){
        int number_of_rows=5;
        //task 1 using while loop
        int x1=1,i=1,j=1,c=0;
        while(i<=number_of_rows){
            j=1;

            while(j<=i){
                System.out.print(c+" ");
                c+=1;
                j++;

            }
            System.out.println();
            i++;
        }
        //task 2 using for loop
        c=0;
        int x2=2;
        for(i=1;i<=number_of_rows;i++){
            for(j=1;j<=i;j++){
                System.out.print(c*x2+" ");
                c++;
            }
            System.out.println();
        }

        //using do-while loop
        int x3=3;
        c=0;
        i=1;
        j=1;
        do{
            j=1;
            do{
                System.out.print(c*x3+" ");
                c+=1;
                j++;
            }while(j<=i);
            i++;
            System.out.println();


        }while(i<=number_of_rows);




    }
}
