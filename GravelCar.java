package com.example;

class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel){
        super(make, model, horsepower);
        this.suspensionTravel= suspensionTravel;
    }

    public double getSuspensionTravel(){
        return suspensionTravel;
    }

    @Override
    public double calculatePerformance(){
        return horsepower * 1.05 + suspensionTravel;
    }
}
