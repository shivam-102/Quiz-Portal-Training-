
package com.impl.lambda;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class MyComaparator implements Comparator<Integer> {
    public int compare(Integer number1,Integer number2){
        return number2.compareTo(number1);
    }
}
public class TreeSet_reverse {
    public static void main(String[] args){
        System.out.println("Using lambda Expression:");
        Set<Integer> treeSet=new TreeSet<>((integer1,integer2)->integer2.compareTo(integer1));
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the amount of elements in the Tree:");
        int amount=scanner.nextInt();
        for(int pointer=0;pointer<amount;pointer++){
            treeSet.add(scanner.nextInt());
        }
        for(Integer number:treeSet){
            System.out.println(number);
        }
        System.out.println("Without Using lambda Expression:");
        TreeSet<Integer> treeSet1=new TreeSet<Integer>(new MyComaparator());
        for(Integer number:treeSet){
            System.out.println(number);
        }
    }
}
