package com.impl.lambda;
import java.util.*;
public class TreeSet_names {
    public static void main(String[] args){
        System.out.println("Using lambda Expression:");
        Set<String> treeSet=new TreeSet<>((string1, string2)->string1.compareTo(string2));
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of Employees:");
        int amount=scanner.nextInt();
        System.out.println("Enter the names:");
        for(int pointer=0;pointer<=amount;pointer++){
            treeSet.add(scanner.nextLine());
        }
        for(String name:treeSet){
            System.out.println(name);
        }
        System.out.println("Without Using lambda Expression:");
        TreeSet<String> treeSet1=new TreeSet<String>();
        Iterator<String> iterator = treeSet1.iterator();
        System.out.println("Enter the names:");
        for(int pointer=0;pointer<=amount;pointer++){
            treeSet.add(scanner.nextLine());
        }
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
