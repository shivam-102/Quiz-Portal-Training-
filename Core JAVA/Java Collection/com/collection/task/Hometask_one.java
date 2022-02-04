package com.collection.task;
import java.util.*;
public class Hometask_one {
    public static void main(String args[]){
        ArrayList<String> arrayList=new ArrayList<String>(5);
        //Adding elements in arraylist
        arrayList.add("Republic Day");
        arrayList.add("Independence Day");
        arrayList.add("Gandhi Jayanthi");
        arrayList.add("Mahavir Jayanthi");
        arrayList.add("Good Friday");
        //Traversing through an arrayList
        Iterator iterator=arrayList.iterator();
        System.out.println("OUTPUT FROM ARRAYLIST : ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //Sorting a ArrayList
        Collections.sort(arrayList);
        System.out.println("In sorted order:");
        for(String i:arrayList){
            System.out.println(i);
        }
        //Element iterating in reverse order
        ListIterator<String> listIterator=arrayList.listIterator(arrayList.size());
        System.out.println("In reverse order:");
        while(listIterator.hasPrevious())
        {
            String str=listIterator.previous();
            System.out.println(str);
        }

        //Linked List
        LinkedList<Telephone> linkedList = new LinkedList<Telephone>();

        //Demonstrating the usage of linked list
        Telephone telephone1=new Telephone("Shivam",123456);
        Telephone telephone2=new Telephone("Azhar",453683);
        Telephone telephone3=new Telephone("Aanchal",3488934);
        Telephone telephone4=new Telephone("Bob",487492);
        Telephone telephone5=new Telephone("John",154321);
        linkedList.add(telephone1);
        linkedList.add(telephone2);
        linkedList.add(telephone3);
        linkedList.add(telephone4);
        linkedList.add(telephone5);
        linkedList.remove(telephone4);
        System.out.println("OUTPUT FROM LINKEDLIST : ");
        for(Telephone t:linkedList){
            System.out.println(t.name+" "+t.PhNo);

        }
        //HashMap
        Map<Integer,Telephone1> map=new HashMap<Integer,Telephone1>();
        Telephone1 buddy1=new Telephone1("Shivam",123456);
        Telephone1 buddy2=new Telephone1("Azhar",453683);
        Telephone1 buddy3=new Telephone1("Aanchal",3488934);
        Telephone1 buddy4=new Telephone1("Bob",487492);
        Telephone1 buddy5=new Telephone1("John",154321);

        map.put(1,buddy1);
        map.put(2,buddy2);
        map.put(3,buddy3);
        map.put(4,buddy4);
        map.put(5,buddy5);
        System.out.println("OUTPUT FROM HASHMAP : ");
        //Traversing map
        for(Map.Entry<Integer, Telephone1> entry:map.entrySet()){
            int key=entry.getKey();
            Telephone1 b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }

        //map remove
        map.remove(4);
        //map replace
        Telephone1 b6=new Telephone1("Deepak",2973);
        map.replace(5,b6);
        for(Map.Entry<Integer, Telephone1> entry:map.entrySet()){
            int key=entry.getKey();
            Telephone1 b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }
        //Linked HashMap
        Map<Integer,Telephone1> linkedHashMap=new LinkedHashMap<Integer,Telephone1>();
        linkedHashMap.put(1,buddy1);
        linkedHashMap.put(2,buddy2);
        linkedHashMap.put(3,buddy3);
        linkedHashMap.put(4,buddy4);
        linkedHashMap.put(5,buddy5);
        linkedHashMap.remove(1);
        //Fetching key
        //System.out.println("Keys: "+lmap.keySet());
        //Fetching value
        System.out.println("OUTPUT FROM LINKED HASHMAN : ");
        for(Map.Entry<Integer, Telephone1> entry:linkedHashMap.entrySet()){
            int key=entry.getKey();
            Telephone1 b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.name+" "+b.PhNo);
        }
        //Hashset
        HashSet<Telephone1> set=new HashSet<Telephone1>();
        //adding elements
        set.add(buddy1);
        set.add(buddy2);
        set.add(buddy3);
        set.add(buddy4);
        set.add(buddy5);
        //remove elements
        set.remove(buddy3);
        //After operations final set
        System.out.println("OUTPUT FROM HASHSET : ");
        for(Telephone1 b:set){
            System.out.println(b.name+" "+b.PhNo);
        }
        //Linked Hashset
        LinkedHashSet<Telephone1> linkedset= new LinkedHashSet<Telephone1>();
        //add elements
        linkedset.add(buddy1);
        linkedset.add(buddy2);
        linkedset.add(buddy3);
        linkedset.add(buddy4);
        linkedset.add(buddy5);
        //remove elements
        linkedset.remove(buddy2);
        System.out.println("OUTPUT FROM LINKED HASHSET : ");
        for(Telephone1 b:linkedset){
            System.out.println(b.name+" "+b.PhNo);
        }
        //TreeSet
        Set<Telephone1> tset=new TreeSet<Telephone1>();
        //adding operations
        tset.add(buddy1);
        tset.add(buddy2);
        tset.add(buddy3);
        tset.add(buddy4);
        tset.add(buddy5);
        //remove values
        tset.remove(buddy3);
        //Printing
        System.out.println("OUTPUT FROM TREESET : ");
        for(Telephone1 b:tset){
            System.out.println(b.name+" "+b.PhNo);
        }

        Map<Integer,Telephone1> treeMap=new TreeMap<Integer,Telephone1>();
        treeMap.put(11,buddy1);
        treeMap.put(12,buddy2);
        treeMap.put(13,buddy3);
        treeMap.put(14,buddy4);
        treeMap.put(15,buddy5);
        //replace an element
        Telephone1 b7=new Telephone1("Ashu", 82182);
        treeMap.replace(13,b7);
        //remove an element
        treeMap.remove(15);
        //print elements
        System.out.println("OUTPUT FROM TREEMAP : ");
        for(Map.Entry<Integer, Telephone1> entry:treeMap.entrySet()){
            int key=entry.getKey();
            Telephone1 b=entry.getValue();
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
class Telephone1 implements Comparable<Telephone1>{
    String name;
    int PhNo;
    public Telephone1(String name,int PhNo){
        this.name=name;
        this.PhNo=PhNo;

    }
    @Override
    public int compareTo(Telephone1 o) {
        return 0;
    }
}