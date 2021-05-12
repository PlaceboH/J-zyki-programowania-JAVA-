package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("hi");

        Car car = new Car(2, 50, false);
        Car speedCar = new RacingCar(4, 200, true);
        Car delCar = new DeliveryCar(3, 100, true);

        System.out.println(car.toString());
        System.out.println(speedCar.toString());
        System.out.println(delCar.toString());
    }
}
