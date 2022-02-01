package com.impl.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the amount of elements in the list:");
        int amount=scanner.nextInt();
        for(int pointer=0;pointer<amount;pointer++){
            list.add(scanner.nextInt());
        }
        //using Lambda Expression
        Collections.sort(list,(p1,p2)->{
            return p2.compareTo(p1);
        });
        for(Integer number : list) {
            System.out.println(number);
        }
        //without Lambda Expression
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("In descending order:"+list);
        scanner.close();
    }
}
