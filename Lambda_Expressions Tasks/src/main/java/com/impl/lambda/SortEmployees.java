package com.impl.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortEmployees {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the amount of elements in the list:");
        int amount=scanner.nextInt();
        for(int pointer=1;pointer<=amount;pointer++){
            list.add(scanner.nextLine());
        }
        //with Lambda Expression
        Collections.sort(list,(p1,p2)->{
            return p1.compareTo(p2);
        });
        for(String output : list) {
            System.out.println(output);
        }

        //Without Lambda Expression
        Collections.sort(list);
        System.out.println("In order:"+list);


    }
}
