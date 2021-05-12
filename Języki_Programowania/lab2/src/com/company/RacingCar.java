package com.company;

public class RacingCar extends Car {

    private class TurboCharger{
       private int boostFactor;

       TurboCharger(int boostFactor){
           this.boostFactor = boostFactor;
       }

        public int getBoostFactor() {
            return boostFactor;
        }
    }
    TurboCharger turbo;

    public RacingCar(int power, double speed, boolean dirty) {
        super(power, speed, dirty);
        turbo = new TurboCharger(2);
    }

    public void accelerate(double x){
        super.accelerate(x);
        speed *= 2 * turbo.getBoostFactor();
    }
    @Override
    public String toString() {
        return String.format("Power: " + getPower() +  "speed: " + speed );
    }
}
