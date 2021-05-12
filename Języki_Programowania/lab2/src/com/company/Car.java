package com.company;

public class Car extends Vehicle {
    private int power;
    protected double speed;
    public boolean dirty;
    private static int maxSpeed = 200;
    protected static final int mass = 100;

    public Car(int power, double speed, boolean dirty){
        this.power = power;
        this.speed = speed;
        this. dirty = dirty;
    }
    public Car( Car car){
        power = car.power;
        speed = car.speed;
        dirty = car.dirty;
    }

    public double getPower() {
        return power;
    }

    public void setPower(int pow) {
        power = pow;
    }

    public void accelerate(double x){
        if(x > 1 ) { x = 1;}
        else if( x < 0){ x = 0;}

        speed += x *power;
    }

    @Override
    public String toString() {
        return String.format("Power: " + power +  "speed: " + speed + "mass" + mass );
    }


    @Override
    void horn() {
        System.out.println("dasdasdas");
    }

    @Override
    public void dirty() {
        if(dirty == false){
            dirty = true;
        }

    }

    @Override
    public void clean() {
        if(dirty == true){
            dirty = false;
        }
    }
}
