package com.impl.lambda;
import java.util.*;
import java.util.function.Supplier;
public class Second_big {

    //without interface
    static int second_largest(ArrayList<Integer> list,int amount){
        Collections.sort(list);
        int element= list.get(amount-2);;
        return element;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        System.out.println("Enter the amount of number you want to keep in the list");
        int amount= scanner.nextInt();
        for(int pointer1=1;pointer1<=amount;pointer1++){
            list.add(scanner.nextInt());
        }
        //with Supplier functional Interface
        Supplier<Integer> supplier=()->{
            Collections.sort(list);
            return list.get(amount-2);
        };

        System.out.println("Second Largest number "+supplier.get());

        //without lambda expressions
        System.out.println("Second Largest number "+Second_big.second_largest((ArrayList) list,amount));
        scanner.close();

    }
}
