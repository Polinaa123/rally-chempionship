package com.example;

class AsphaltCar extends RallyCar{
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce= downforce;
    }

    public double getDownforce(){
        return downforce;
    }

    @Override
    public double calculatePerformance(){
        return horsepower * 1.1 + downforce;
    }
}
