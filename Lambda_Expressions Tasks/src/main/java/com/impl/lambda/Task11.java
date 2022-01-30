package com.impl.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task11 {
    public static <Sting> void main(String[] args){
        List<String> Employees = new ArrayList<String>();
        Employees.add("Shivam");
        Employees.add("Azhar");
        Employees.add("Aanchal");
        Employees.add("Durga");
        Employees.add("Modi");

        //with lambda expression
        Comparator<String> comparator=(object1,object2)->{
            return object2.compareTo(object1);
        };
        Collections.sort(Employees,comparator);
        for(String name:Employees){
            System.out.println(name);
        }
        //without lambda
        Collections.sort(Employees, Collections.reverseOrder());
        for(String name:Employees){
            System.out.println(name);
        }

    }
}
