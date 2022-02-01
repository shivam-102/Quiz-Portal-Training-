package com.task.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
class Product{
String name;
String category;
String grade;
float price;
Product(String name, float price, String category,String grade ){
    this.name=name;
    this.price=price;
    this.category=category;
    this.grade=grade;
}
}
public class Task {
    public static void main(String[] args){
        List<Product> productList=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String name;
        String category;
        String grade;
        float price;
        System.out.println("Enter the number of products you want to include:");
        int number= scanner.nextInt();
        for(int pointer=0;pointer<number;pointer++){
            System.out.println("Enter name of product "+(pointer+1));
            name= scanner.next();
            System.out.println("Enter price of product "+(pointer+1));
            price=scanner.nextFloat();
            System.out.println("Enter category of product "+(pointer+1));
            category=scanner.next();
            System.out.println("Enter grade of product "+(pointer+1));
            grade=scanner.next();
            productList.add(new Product(name,price,category,grade));
        }
        //Question-1
        List<Float> greaterThanThousand= (List<Float>) productList.stream()
                        .filter(product -> product.price>1000)
                                .map(product -> product.price)
                                        .collect(Collectors.toList());

        System.out.println(greaterThanThousand);
        String electronic= "electronic";

        //Question-2
        List<String> names= (List<String>) productList.stream()
                .filter(product -> product.category.equals(electronic))
                        .map(product -> product.name)
                                .collect(Collectors.toList());
        System.out.println(names);
        /* Question-3 */
        List<String> match= (List<String>) productList.stream()
                .filter(product -> product.category.equals(electronic))
                .filter(product -> product.price>1000)
                .map(product -> product.name.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
        for(String string:match){
            System.out.println(string);
        }
        //Question-4
        Long count=productList.stream()
                .filter(product -> product.category.equals(electronic))
                .count();
        System.out.println(count);
    }
}
