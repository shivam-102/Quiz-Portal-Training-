package com.collection.task;

import java.util.*;
public class Hometask_one {

    public static void main(String args[]){

        ArrayList<String> arr=new ArrayList<String>(5);
        //Adding elements in arraylist
        arr.add("Republic Day");
        arr.add("Independence Day");
        arr.add("Gandhi Jayanthi");
        arr.add("Mahavir Jayanthi");
        arr.add("Good Friday");
        //Traversing through an arrayList
        Iterator itr=arr.iterator();
        System.out.println("OUTPUT FROM ARRAYLIST : ");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //Sorting a ArrayList
        Collections.sort(arr);
        System.out.println("In sorted order:");
        for(String i:arr){
            System.out.println(i);
        }
        //Element iterating in reverse order
        ListIterator<String> l1=arr.listIterator(arr.size());
        System.out.println("In reverse order:");
        while(l1.hasPrevious())
        {
            String str=l1.previous();
            System.out.println(str);
        }

        //Linked List
        LinkedList<Telephone> ll = new LinkedList<Telephone>();

        //Demonstrating the usage of linked list
        Telephone t1=new Telephone("Shivam",123456);
        Telephone t2=new Telephone("Azhar",453683);
        Telephone t3=new Telephone("Aanchal",3488934);
        Telephone t4=new Telephone("Bob",487492);
        Telephone t5=new Telephone("John",154321);
        ll.add(t1);
        ll.add(t2);
        ll.add(t3);
        ll.add(t4);
        ll.add(t5);
        ll.remove(t4);
        System.out.println("OUTPUT FROM LINKEDLIST : ");
        for(Telephone t:ll){
            System.out.println(t.name+" "+t.PhNo);

        }
        //HashMap
        Map<Integer,Bo> map=new HashMap<Integer,Bo>();
        Bo b1=new Bo("Shivam",123456);
        Bo b2=new Bo("Azhar",453683);
        Bo b3=new Bo("Aanchal",3488934);
        Bo b4=new Bo("Bob",487492);
        Bo b5=new Bo("John",154321);

        map.put(1,b1);
        map.put(2,b2);
        map.put(3,b3);
        map.put(4,b4);
        map.put(5,b5);
        System.out.println("OUTPUT FROM HASHMAP : ");
        //Traversing map
        for(Map.Entry<Integer, Bo> entry:map.entrySet()){
            int key=entry.getKey();
            Bo b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }

        //map remove
        map.remove(4);
        //map replace
        Bo b6=new Bo("Deepak",2973);
        map.replace(5,b6);

        for(Map.Entry<Integer, Bo> entry:map.entrySet()){
            int key=entry.getKey();
            Bo b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }


        //Linked HashMap

        Map<Integer,Bo> lmap=new LinkedHashMap<Integer,Bo>();


        lmap.put(1,b1);
        lmap.put(2,b2);
        lmap.put(3,b3);
        lmap.put(4,b4);
        lmap.put(5,b5);

        lmap.remove(1);

        //Fetching key
        //System.out.println("Keys: "+lmap.keySet());
        //Fetching value
        System.out.println("OUTPUT FROM LINKED HASHMAN : ");
        for(Map.Entry<Integer, Bo> entry:lmap.entrySet()){
            int key=entry.getKey();
            Bo b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }

        //Hashset
        HashSet<Bo> set=new HashSet<Bo>();
        //adding elements
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);
        //remove elements
        set.remove(b3);
        //After operations final set
        System.out.println("OUTPUT FROM HASHSET : ");
        for(Bo b:set){
            System.out.println(b.name+" "+b.PhNo);
        }

        //Linked Hashset
        LinkedHashSet<Bo> linkedset= new LinkedHashSet<Bo>();
        //add elements
        linkedset.add(b1);
        linkedset.add(b2);
        linkedset.add(b3);
        linkedset.add(b4);
        linkedset.add(b5);
        //remove elements
        linkedset.remove(b2);
        System.out.println("OUTPUT FROM LINKED HASHSET : ");
        for(Bo b:linkedset){
            System.out.println(b.name+" "+b.PhNo);
        }
        //TreeSet
        Set<Bo> tset=new TreeSet<Bo>();
        //adding operations
        tset.add(b1);
        tset.add(b2);
        tset.add(b3);
        tset.add(b4);
        tset.add(b5);

        //remove values
        tset.remove(b3);
        //Printing
        System.out.println("OUTPUT FROM TREESET : ");
        for(Bo b:tset){
            System.out.println(b.name+" "+b.PhNo);
        }

        Map<Integer,Bo> map1=new TreeMap<Integer,Bo>();

        map1.put(11,b1);
        map1.put(12,b2);
        map1.put(13,b3);
        map1.put(14,b4);
        map1.put(15,b5);
        //replace an element
        Bo b7=new Bo("Ashu", 82182);
        map1.replace(13,b7);
        //remove an element
        map1.remove(15);

        //print elements
        System.out.println("OUTPUT FROM TREEMAP : ");
        for(Map.Entry<Integer, Bo> entry:map1.entrySet()){
            int key=entry.getKey();
            Bo b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }
    }
}
//for linkedlist
class Telephone{
    String name;
    int PhNo;
    public Telephone(String name,int PhNo){
        this.name=name;
        this.PhNo=PhNo;

    }

}
//for remaining all
class Bo implements Comparable<Bo>{
    String name;
    int PhNo;
    public Bo(String name,int PhNo){
        this.name=name;
        this.PhNo=PhNo;

    }
    @Override
    public int compareTo(Bo o) {
        return 0;
    }
}