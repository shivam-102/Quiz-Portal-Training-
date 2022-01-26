package com.tasks.impl;
import java.util.Scanner;

public class Loops_Arrays_Hometask {
    //Question 1
    /*
    public static int maxSpan(int[] nums) {
        int l=nums.length;
        int span=0,c=0;
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(nums[i]==nums[j]){
                    c=j-i+1;
                    if(c>span)
                        span=c;
                }
            }
        }
        return span;
    }


    //Question 2
    public static boolean canBalance(int[] nums) {
        int l=nums.length;

        int s1=0,s2=0;
        for(int i=0;i<l;i++){
            s1=s1+nums[i];
            s2=0;
            for(int j=l-1;j>i;j--){
                s2+=nums[j];
            }
            if(s1==s2)
                return true;

        }
        return false;

    }


    //Question 3
    public static int countClumps(int[] nums) {
        int l=nums.length;
        int c=1,clu=0;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(nums[i]==nums[j]){
                    c++;
                }
                else{
                    if(c>=2)
                        clu++;
                    i=j;
                }

            }
            if(c==l){
                clu=1;
            }
        }
        return clu;
    }
    */

    //Question 4
    //Question 5

    public static boolean linearIn(int[] outer, int[] inner) {
        int c=0,cu=0;
        for(int i=0;i<inner.length;i++){
            c=0;
            for(int j=0;j<outer.length;j++){
                if(inner[i]==outer[j]){
                    c++;
                }
            }
            if(c>0)
                cu++;
        }
        if(cu==inner.length)
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //Question 1
        /*
        System.out.println("Enter array length:");
        int l=sc.nextInt();
        System.out.println("Enter array values:");
        int arr[]=new int[l];
        for(int i=0;i<l;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.maxSpan(arr));


        //Question 2
        System.out.println("Enter array length:");
        int le=sc.nextInt();
        System.out.println("Enter array values:");
        int arr[]=new int[le];
        for(int i=0;i<le;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.canBalance(arr));

        //Question 3
        System.out.println("Enter array length:");
        int len=sc.nextInt();
        System.out.println("Enter array values:");
        int a[]=new int[len];
        for(int i=0;i<len;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.countClumps(a));
        */
        //Question 4

        //Question 5
        System.out.println("Enter array1 length:");
        int le1=sc.nextInt();
        System.out.println("Enter array2 length:");
        int le2=sc.nextInt();
        System.out.println("Enter array values:");
        int outer[]=new int[le1];
        int inner[]=new int[le2];
        for(int i=0;i<le1;i++){
            outer[i]=sc.nextInt();
        }
        for(int i=0;i<le2;i++){
            inner[i]=sc.nextInt();
        }
        System.out.println("The result for maxSpan:"+Loops_Arrays_Hometask.linearIn(outer,inner));





    }
}
