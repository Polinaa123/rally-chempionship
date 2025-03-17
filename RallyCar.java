package com.example;

abstract class RallyCar {
    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower){
        this.make= make;
        this.model= model;
        this.horsepower= horsepower;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int horsepower(){
        return horsepower;
    }

    public abstract double calculatePerformance();
}

