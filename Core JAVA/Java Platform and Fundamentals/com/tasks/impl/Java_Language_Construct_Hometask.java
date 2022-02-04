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
    public static boolean truelyGreatNumber(int value1,int value2){
        if((value1==6)||(value2==6)||(value1+value2==6)||(value1-value2==6))
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
    public static int blueTicket(int value1, int value2, int value3) {
        int sum1=value1+value2;
        int sum2=value2+value3;
        int sum3=value1+value3;
        if(sum1==10||sum2==10||sum3==10){return 10;}
        else if((sum1-sum2==10)||(sum1-sum3==10)){return 5;}
        else{return 0;}
    }
    //Question 5
    public static boolean inOrder(int val1, int val2, int val3, boolean bOk) {
        if(bOk){
            if(val3>val2){return true;}
            else{return false;}
        }
        if(val2>val1 && val3>val2){return true;}
        else{return false;}
    }
    //Question-6
    public static boolean shareDigit(int val1, int val2) {
        int val1division=val1/10;
        int val1modulus=val1%10;
        int val2division=val2/10;
        int val2modulus=val2%10;
        if(val1division==val2division||val1division==val2modulus||val1modulus==val2division||val1modulus==val2modulus)
        {
            return true;
        }
        else{
            return false;
        }
    }

   //Question-7
    public static int sumLimit(int value1, int value2) {
        int sum=value1+value2;
        String sum_value=String.valueOf(sum);
        String value1_value=String.valueOf(value1);
        if(sum_value.length()>value1_value.length()){
            return value1;
        }
        else{
            return sum;
        }
  }
    //Question-8

    public static String withoutString(String base, String remove) {
    base=base.replace(remove.toUpperCase(),"");
    base=base.replace(remove.toLowerCase(),"");
    return base.replace(remove,"");
}
    //Question-9
    public static int maxBlock(String string) {
        int count = 0;
        int max = 0;
        for (int pointer = 0; pointer < string.length(); pointer++) {
            if (pointer == 0) {
                count++;
                max = count;
            } else if (str.charAt(pointer) == str.charAt(pointer - 1)) {
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
        String current="";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                current=current+Character.toString(str.charAt(i));
            }else if(current!="") {
                sum=sum+Integer.parseInt(current);
                current="";
            }if(current!="" && i==str.length()-1){
                sum=sum+Integer.parseInt(current);
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        //Question 1
        /*
        System.out.println("Enter your speed");
        int speed=scanner.nextInt();
        System.out.println("Is it your birthday?(true/false)");
        boolean isBirthday = scanner.nextBoolean();
        System.out.println(Java_Language_Construct_Hometask.caughtSpeeding(speed,isBirthday));
        //Question 2 - Truely great Number
        System.out.println("Enter a");
        int variable1=scanner.nextInt();
        System.out.println("Enter b");
        int variable2=scanner.nextInt();
        System.out.println(Java_Language_Construct_Hometask.truelyGreatNumber(Math.abs(variable1),Math.abs(variable2)));
        //Question 3
        System.out.println("Enter tea value:");
        int tea=scanner.nextInt();
        System.out.println("Enter candy value:");
        int candy=scanner.nextInt();
        int response= Java_Language_Construct_Hometask.teaParty(tea,candy);
        switch(response){
            case 0: System.out.println("bad");
            break;
            case 1: System.out.println("good");
            break;
            case 2: System.out.println("great");
            break;
            default: System.out.println("Did not get proper value");
        }
        //Question - 4
        System.out.println("Enter a");
        int number1=scanner.nextInt();
        System.out.println("Enter b");
        int number2=scanner.nextInt();
        System.out.println("Enter c");
        int number3=scanner.nextInt();
        System.out.println("Required output:"+Java_Language_Construct_Hometask.blueTicket(number1,number2,number3));
        //Question -5
        System.out.println("Enter a");
        int aVar=scanner.nextInt();
        System.out.println("Enter b");
        int bVar=scanner.nextInt();
        System.out.println("Enter c");
        int cVar=scanner.nextInt();
        System.out.println("Enter bOk value:");
        boolean bOk=scanner.nextBoolean();
        System.out.println("Required output of inorder problem:"+Java_Language_Construct_Hometask.inOrder(aVar,bVar,cVar,bOk));
        //Question -6
        System.out.println("Enter a");
        int value1=scanner.nextInt();
        System.out.println("Enter b");
        int value2=scanner.nextInt();
        System.out.println("Required output for shareDigit:"+Java_Language_Construct_Hometask.shareDigit(value1,value2));
        //Question-7
        System.out.println("Enter a");
        int value4=scanner.nextInt();
        System.out.println("Enter b");
        int value5=scanner.nextInt();
        System.out.println("Required output for sumLimit:"+Java_Language_Construct_Hometask.sumLimit(value4,value5));

        //Question-8
        System.out.println("Enter base string:");
        String base=scanner.nextLine();
        System.out.println("Enter remove string:");
        String remove=scanner.nextLine();
        System.out.println("Required output for maxBlock:"+Java_Language_Construct_Hometask.withoutString(base,remove));
        //Question-9
        System.out.println("Enter string");
        String string=scanner.nextLine();
        System.out.println("Required output for maxBlock:"+Java_Language_Construct_Hometask.sumLimit(string));

        */

        //Question -10
        System.out.println("Enter string:");
        String string1=scanner.nextLine();
        System.out.println("Required output for maxBlock:"+Java_Language_Construct_Hometask.sumNumbers(string1));
    }

}
