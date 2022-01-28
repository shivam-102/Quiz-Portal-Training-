package com.tasks.impl;

import java.util.Scanner;

public class Java_Language_Construct_Hometask {
    //declared this as static so that there would need to keep a object
    //Question-1
    /*public static int caughtSpeeding(int speed, boolean isBirthday) {
        if(isBirthday==true){speed-=5;}
        if(speed<=60){return 0;}
        else if(speed>60 && speed <=80){return 1;}
        else if(speed>80){return 2;}
        else{return -1;}
    }

    //Question-2
    public static boolean truelyGreatNumber(int a,int b){
        if((a==6)||(b==6)||(a+b==6)||(a-b==6))
            return true;
        else
            return false;


    }

    //Question-3
    public static int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5) {return 0;}
        if (tea >= 2 * candy || candy >= 2 * tea){return 2;}
        if (tea >= 5 && candy >= 5){return 1;}
        return -1;
    }
    //Question-4
    public static int blueTicket(int a, int b, int c) {
        int p1=a+b;
        int p2=b+c;
        int p3=a+c;
        if(p1==10||p2==10||p3==10){return 10;}
        else if((p1-p2==10)||(p1-p3==10)){return 5;}
        else{return 0;}
    }

    //Question 5
    public static boolean inOrder(int a, int b, int c, boolean bOk) {
        if(bOk){
            if(c>b){return true;}
            else{return false;}
        }
        if(b>a && c>b){return true;}
        else{return false;}
    }


    //Question-6
    public static boolean shareDigit(int a, int b) {
        int ad=a/10;
        int am=a%10;
        int bd=b/10;
        int bm=b%10;
        if(ad==bd||ad==bm||am==bd||am==bm)
        {
            return true;
        }
        else{
            return false;
        }
    }



    //Question-7
    public static int sumLimit(int a, int b) {
        int n=a+b;
        String n_value=String.valueOf(n);
        String a_value=String.valueOf(a);
        if(n_value.length()>a_value.length()){
            return a;
        }
        else{
            return n;
        }


    }



    //Question-8

    public static String withoutString(String base, String remove) {
    base=base.replace(remove.toUpperCase(),"");
    base=base.replace(remove.toLowerCase(),"");
    return base.replace(remove,"");
}



    //Question-9
    public static int maxBlock(String str) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                count++;
                max = count;
            } else if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }
        return max;
    }
    */
    //Question -10
    public static int sumNumbers(String str) {
        int sum=0;
        String curr="";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                curr=curr+Character.toString(str.charAt(i));
            }else if(curr!="") {
                sum=sum+Integer.parseInt(curr);
                curr="";
            }if(curr!="" && i==str.length()-1){
                sum=sum+Integer.parseInt(curr);
            }
        }
        return sum;
    }



    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //Question 1
        /*
        System.out.println("Enter your speed");
        int speed=sc.nextInt();
        System.out.println("Is it your birthday?(true/false)");
        boolean isBirthday = sc.nextBoolean();
        System.out.println(Java_Language_Construct_Hometask.caughtSpeeding(speed,isBirthday));

        //Question 2 - Truely great Number
        System.out.println("Enter a");
        int a=sc.nextInt();
        System.out.println("Enter b");
        int b=sc.nextInt();
        System.out.println(Java_Language_Construct_Hometask.truelyGreatNumber(Math.abs(a),Math.abs(b)));



        //Question 3
        System.out.println("Enter tea value:");
        int tea=sc.nextInt();
        System.out.println("Enter candy value:");
        int candy=sc.nextInt();
        int r= Java_Language_Construct_Hometask.teaParty(tea,candy);
        switch(r){
            case 0: System.out.println("bad");
            break;
            case 1: System.out.println("good");
            break;
            case 2: System.out.println("great");
            break;
            default: System.out.println("did'nt get proper value");
        }
        //Question - 4

        System.out.println("Enter a");
        int a1=sc.nextInt();
        System.out.println("Enter b");
        int b1=sc.nextInt();
        System.out.println("Enter c");
        int c1=sc.nextInt();
        System.out.println("Required output:"+Java_Language_Construct_Hometask.blueTicket(a1,b1,c1));


        //Question -5
        System.out.println("Enter a");
        int a2=sc.nextInt();
        System.out.println("Enter b");
        int b2=sc.nextInt();
        System.out.println("Enter c");
        int c2=sc.nextInt();
        System.out.println("Enter bOk value:");
        boolean bOk=sc.nextBoolean();
        System.out.println("Required output of inorder problem:"+Java_Language_Construct_Hometask.inOrder(a2,b2,c2,bOk));


        //Question -6
        System.out.println("Enter a");
        int a3=sc.nextInt();
        System.out.println("Enter b");
        int b3=sc.nextInt();
        System.out.println("Required output for shareDigit:"+Java_Language_Construct_Hometask.shareDigit(a3,b3));


        //Question-7
        System.out.println("Enter a");
        int a4=sc.nextInt();
        System.out.println("Enter b");
        int b4=sc.nextInt();
        System.out.println("Required output for sumLimit:"+Java_Language_Construct_Hometask.sumLimit(a4,b4));

        //Question-8
        System.out.println("Enter base string:");
        String base=sc.nextLine();
        System.out.println("Enter remove string:");
        String remove=sc.nextLine();
        System.out.println("Required output for maxBlock:"+Java_Language_Construct_Hometask.withoutString(base,remove));



        //Question-9
        System.out.println("Enter string");
        String str=sc.nextLine();
        System.out.println("Required output for maxBlock:"+Java_Language_Construct_Hometask.sumLimit(str));

        */

        //Question -10
        System.out.println("Enter string:");
        String str1=sc.nextLine();
        System.out.println("Required output for maxBlock:"+Java_Language_Construct_Hometask.sumNumbers(str1));



    }

}
