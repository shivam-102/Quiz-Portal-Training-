package com.tasks.impl;

public class Basic {

    public static void main(String[] args){
        try {
            System.out.println("Hello:" + args[0]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
