package com.company;

public class DeliveryCar extends Car {

    private int load;
    static private int capacity;
    public DeliveryCar(int power, double speed, boolean dirty) {
        super(power, speed, dirty);

    }


    public void accelerate(double x){
        super.accelerate(x);
        speed -= load;
    }

    @Override
    public String toString() {
        return String.format("Power: " + getPower() +  "speed: " + speed + "load: " + load );
    }

}
