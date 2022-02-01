package com.impl.lambda;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapSortEmployees {
    public static void main(String[] args){
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        treeMap.put("Shivam",670);
        treeMap.put("Durga",201);
        treeMap.put("Deepak",50);
        treeMap.put("Azhar",5);
        treeMap.put("Garvit",890);
        treeMap.put("Sashank",114);
        Map<String,Integer> sortedMap=new TreeMap<>((key1, key2)->key2.compareTo(key1));
        sortedMap.putAll(treeMap);
        System.out.println(sortedMap);
    }
}
