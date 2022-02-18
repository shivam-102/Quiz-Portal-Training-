package com.Task.JUnit;
public class TDDTask {
    public static String removal(String string){
        return string.substring(0,2).replace("A","")+string.substring(2,string.length());
    }
}
