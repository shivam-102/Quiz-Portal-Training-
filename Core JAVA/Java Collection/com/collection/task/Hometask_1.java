package com.collection.task;
//continuation of Hometask 1
import java.util.*;
public class Hometask_1{
    public static void main(String[] args) {
        Map<Integer, Information> map = new HashMap<>();
        //Val class assignment of values
        Information value1 = new Information("Shivam", "Jamshedpur");
        Information value2 = new Information("Azhar", "Tatanagar");
        Information value3 = new Information("Aanchal", "Delhi");
        Information value4 = new Information("Deepak", "Ajmer");
        Information value5 = new Information("Pavan", "Hyderabad");
        //add elements
        map.put(101,value1);
        map.put(102,value2);
        map.put(103,value3);
        map.put(104,value4);
        map.put(105,value5);
        //replacing elements
        Information value6 = new Information("Durga", "Minsk");
        map.replace(101,value6);
        //remove element
        map.remove(104);
        //Printing the final elements in the HashMap
        System.out.println("Printing the final keys and values in the hashmap:-");
        for(Map.Entry<Integer, Information> entry:map.entrySet()){
            Integer key=entry.getKey();
            Information var=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(var.name+" "+var.city);
        }
    }
}
  class Information{
    String name;
    String city;
    public Information(String name, String city){
        this.name=name;
        this.city=city;
    }
}
