package com.oops.task;

public class Customer {

    String name;
    Sweets sweets;

    int getmaxCost(){
        int maxCost= sweets.chocolate.maxWeight+sweets.othersweets.maxWeight;
        return maxCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sweets getCar() {
        return sweets;
    }

    public void setCar(Sweets car) {
        this.sweets = car;
    }
}
