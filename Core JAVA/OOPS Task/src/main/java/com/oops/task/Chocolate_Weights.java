package com.oops.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Chocolate_Weights {
    Map chocolateWeights=new HashMap();

    void addWeight(String name,int weight){
        chocolateWeights.put(name,weight);
    }

    HashMap sales(){
        return (HashMap) chocolateWeights;

    }
}
