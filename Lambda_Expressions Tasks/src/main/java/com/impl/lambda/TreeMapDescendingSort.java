package com.impl.lambda;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapDescendingSort {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Shivam", 102);
        treeMap.put("Azhar", 203);
        treeMap.put("Akhil", 509);
        treeMap.put("Deepak", 20);
        treeMap.put("Durga", 199);
        treeMap.put("Harsh", 90);
        Map<String,Integer> sortedMap=new TreeMap<>((key1, key2)->treeMap.get(key2).compareTo(treeMap.get(key1)));
        sortedMap.putAll(treeMap);
        System.out.println(sortedMap);

    }
}


