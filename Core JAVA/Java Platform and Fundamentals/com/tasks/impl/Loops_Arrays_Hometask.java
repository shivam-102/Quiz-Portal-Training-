package com.tasks.impl;
import java.util.Scanner;
public class Loops_Arrays_Hometask {
    //Question 1
    /*
    public static int maxSpan(int[] numbers) {
        int len=numbers.length;
        int span=0,count=0;
        for(int pointer=0;pointer<len;pointer++){
            for(int pointer1=0;pointer1<len;pointer1++){
                if(numbers[pointer]==numbers[pointer1]){
                    count=pointer1-pointer+1;
                    if(count>span)
                        span=count;
                }
            }
        }
        return span;
    }


    //Question 2
    public static boolean canBalance(int[] numbers) {
        int len=numbers.length;
        int sum1=0,sum2=0;
        for(int pointer=0;pointer<len;pointer++){
            sum1=sum1+numbers[pointer];
            sum2=0;
            for(int pointer1=len-1;pointer1>pointer;pointer1--){
                sum2+=numbers[pointer1];
            }
            if(sum1==sum2)
                return true;
        }
        return false;
}
    //Question 3
    public static int countClumps(int[] numbers) {
        int len=numbers.length;
        int counter=1,clu=0;
        for(int pointer=0;pointer<len;pointer++){
            for(int pointer1=pointer+1;pointer1<len;pointer1++){
                if(numbers[pointer]==numbers[pointer1]){
                    counter++;
                }
                else{
                    if(counter>=2)
                        clu++;
                    pointer=pointer1;
                }

            }
            if(counter==len){
                clu=1;
            }
        }
        return clu;
        }
    */

    //Question 4
    public int maxMirror(int[] numbers) {
        int temp = 0, max = 0, count = 0;
        int len = numbers.length;
        if(len == 1) return 1;
        for(int pointer=0;pointer<len; pointer++) {
            count = 0;
            temp = pointer;
            for(int pointer2 =(len-1);pointer2>=temp;pointer2--){
                if(numbers[temp] == numbers[pointer2]) {
                    if(temp == pointer2) {
                        count++;
                        if(count == 1) count++;
                        else count = (count * 2) -1;
                        temp++;
                        continue;
                    }
                    count++;
                    temp++;
                }
                else if(count > 0) {
                    if(max < count) max = count;
                    temp = pointer;
                    count = 0;
                }
            }
            if(max < count) max = count;
        }
        return max;
    }
    //Question 5

    public static boolean linearIn(int[] outer, int[] inner) {
        int count=0,cursor=0;
        for(int pointer=0;pointer<inner.length;pointer++){
            count=0;
            for(int pointer1=0;pointer1<outer.length;pointer1++){
                if(inner[pointer]==outer[pointer1]){
                    count++;
                }
            }
            if(count>0)
                cursor++;
        }
        if(cursor==inner.length)
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        //Question 1
        /*
        System.out.println("Enter array length:");
        int length=scanner.nextInt();
        System.out.println("Enter array values:");
        int array[]=new int[length];
        for(int pointer=0;pointer<length;pointer++){
            array[pointer]=scanner.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.maxSpan(array));


        //Question 2
        System.out.println("Enter array length:");
        int length=scanner.nextInt();
        System.out.println("Enter array values:");
        int array[]=new int[length];
        for(int pointer=0;pointer<length;pointer++){
            array[pointer]=scanner.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.canBalance(array));

        //Question 3
        System.out.println("Enter array length:");
        int length=scanner.nextInt();
        System.out.println("Enter array values:");
        int array[]=new int[length];
        for(int pointer=0;pointer<length;pointer++){
            array[pointer]=scanner.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.countClumps(array));

        //Question 4
        System.out.println("Enter array1 length:");
        int lengthX=scanner.nextInt();
        int array[]=new int[lengthX];
        for(int pointer=0;pointer<length1;pointer++){
            array[pointer]=scanner.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.maxMirror(array));

         */

        //Question 5
        System.out.println("Enter array1 length:");
        int length1=scanner.nextInt();
        System.out.println("Enter array2 length:");
        int length2=scanner.nextInt();
        System.out.println("Enter array values:");
        int outer[]=new int[length1];
        int inner[]=new int[length2];
        for(int pointer=0;pointer<length1;pointer++){
            outer[pointer]=scanner.nextInt();
        }
        for(int pointer=0;pointer<length2;pointer++){
            inner[pointer]=scanner.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.linearIn(outer,inner));
    }
}
