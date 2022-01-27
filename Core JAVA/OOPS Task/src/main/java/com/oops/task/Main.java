package com.oops.task;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Customer cust=new Customer();
        Mahindra mahi=new Mahindra();
        OtherCars otc=new OtherCars();
        System.out.println("Enter Name of the customer");
        cust.setName(sc.next());
        System.out.println("Enter max cost of the car");
        mahi.setmaxCost(sc.nextInt());
        System.out.println("Enter max cost of other cars");
        otc.setmaxCost(sc.nextInt());
        int sum = mahi.getmaxCost() + otc.getmaxCost();
        System.out.println("Name of the customer : " + cust.name);
        System.out.println("Total cost of cars : " + sum + "rupees");
        System.out.println();


        sc.close();



    }
}
