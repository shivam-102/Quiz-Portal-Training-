package com.oops.task;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Chocolate_Weights weights=new Chocolate_Weights();
        System.out.println("Enter the number of customers");
        int number=scanner.nextInt();
        while(number>0){
            Customer customer=new Customer();
            Chocolate chocolate=new Chocolate();
            OtherSweets otherSweets=new OtherSweets();
            System.out.println("Enter Name of the customer");
        String nam=scanner.next();
        customer.setName(nam);
        System.out.println("Enter weight of the chocolate");
        chocolate.setmaxWeight(scanner.nextInt());
        System.out.println("Enter weight of other sweets");
        otherSweets.setmaxWeight(scanner.nextInt());
        int sum = chocolate.getmaxWeight() + otherSweets.getmaxWeight();
        weights.addWeight(nam,sum);
        System.out.println("Name of the customer : " + customer.name);
        System.out.println("Total weight of sweets : " + sum + "gms");
        System.out.println();
        number--;
    }
        System.out.println("Today's sales: ");
        HashMap map=weights.sales();
        System.out.println(map.entrySet());
        scanner.close();
    }
}



