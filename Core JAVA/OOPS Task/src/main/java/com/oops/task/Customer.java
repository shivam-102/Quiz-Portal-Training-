package com.oops.task;

public class Customer {

    String name;
    Car car;

    int getmaxCost(){
        int maxCost= car.mahindra.maxCost+car.othercars.maxCost;
        return maxCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
