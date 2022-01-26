package com.collection.task;
//continuation of Hometask 1

import java.util.*;

public class Hometask_1{
    public static void main(String args[]) {
        Map<Integer, Val> map = new HashMap<Integer, Val>();


        //Val class assignment of values
        Val v1 = new Val("Shivam", "Jamshedpur");
        Val v2 = new Val("Azhar", "Tatanagar");
        Val v3 = new Val("Aanchal", "Delhi");
        Val v4 = new Val("Deepak", "Ajmer");
        Val v5 = new Val("Pavan", "Hyderabad");

        //add elements
        map.put(101,v1);
        map.put(102,v2);
        map.put(103,v3);
        map.put(104,v4);
        map.put(105,v5);

        //replacing elements

        Val v6 = new Val("Durga", "Minsk");

        map.replace(101,v6);

        //remove element
        map.remove(104);

        //Printing the final elements in the HashMap
        System.out.println("Printing the final keys and values in the hashmap:-");
        for(Map.Entry<Integer, Val> entry:map.entrySet()){
            Integer key=entry.getKey();
            Val v=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(v.name+" "+v.city);
        }

    }
}
  class Val{
    String name;
    String city;
    public Val(String name, String city){
        this.name=name;
        this.city=city;
    }

 }
