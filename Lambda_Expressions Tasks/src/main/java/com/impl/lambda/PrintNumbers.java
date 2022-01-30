package com.impl.lambda;

public class PrintNumbers {
    public static void main(String[] args){
        Runnable runnable=()->{
            for(int pointer1=10;pointer1<=100;pointer1++){
                System.out.println(pointer1);
            }
        };
        new Thread(runnable).run();
    }
}
