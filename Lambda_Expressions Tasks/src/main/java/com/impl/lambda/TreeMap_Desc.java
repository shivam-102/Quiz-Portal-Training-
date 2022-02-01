package com.impl.lambda;

import java.util.*;

public class TreeMap_Desc {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of inputs:");
        TreeMap<String,Integer> treeMap=new TreeMap<String,Integer>();
        treeMap.put("Shivam",102);
        treeMap.put("Azhar",203);
        treeMap.put("Akhil",509);
        treeMap.put("Deepak",20);
        treeMap.put("Durga",199);
        treeMap.put("Harsh",90);
        SortedMap<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
    }
}


