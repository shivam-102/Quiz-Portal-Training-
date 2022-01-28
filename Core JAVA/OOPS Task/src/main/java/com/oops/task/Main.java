package com.oops.task;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Chocolate_Weights weights=new Chocolate_Weights();
        System.out.println("Enter the number of customers");
        int n=sc.nextInt();
        while(n>0){


        Customer cust=new Customer();
        Chocolate chocolate=new Chocolate();
        OtherSweets otc=new OtherSweets();

        System.out.println("Enter Name of the customer");
        String nam=sc.next();
        cust.setName(nam);
        System.out.println("Enter weight of the chocolate");
        chocolate.setmaxWeight(sc.nextInt());
        System.out.println("Enter weight of other sweets");
        otc.setmaxWeight(sc.nextInt());
        int sum = chocolate.getmaxWeight() + otc.getmaxWeight();
        weights.addWeight(nam,sum);
        System.out.println("Name of the customer : " + cust.name);
        System.out.println("Total weight of sweets : " + sum + "gms");
        System.out.println();
        n--;
    }
        System.out.println("Today's sales: ");
        HashMap map=weights.sales();
        System.out.println(map.entrySet());
        sc.close();
    }
}



