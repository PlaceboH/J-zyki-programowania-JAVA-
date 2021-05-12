package com.company;
import java.util.ArrayList;
import java.lang.Math;

public class Pirate implements Runnable {
    private Thread thread;

    private double x, y;
    private int r;
    private double speed;
    private int goldIndex;
    private boolean isRun = false;
    private int golds = 0;

    public Pirate(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
        speed = 1;
    }

    private int findGold(ArrayList<Gold> gold){

        double sDistance = Math.abs(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) - Math.sqrt(Math.pow(gold.get(0).getX(), 2) + Math.pow(gold.get(0).getY(), 2)));
        int close = 0;
        for(int i  = 0; i < gold.size(); i++){
            double actualDistanceGold = Math.sqrt(Math.pow(gold.get(i).getX(), 2) + Math.pow(gold.get(i).getY(), 2));
            double actualDistancePirate = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            if( sDistance > Math.abs(actualDistanceGold - actualDistancePirate)){
                sDistance = actualDistanceGold;
                close = i;
            }
        }

        return close;
    }


    public void update(ArrayList<Gold> gold){

        if(!isRun){
            startGold();
        }
        if(gold.size() > 0) {

            boolean detected = gold.get(goldIndex).isDetected();
            if(detected) {
                goldIndex = findGold(gold);
            }

            if (x > gold.get(goldIndex).getX()) {
                x -= speed;

            } else if (x < gold.get(goldIndex).getX()) {
                x += speed;
            }


            if (y > gold.get(goldIndex).getY()) {
                y -= speed;
            } else if (y < gold.get(goldIndex).getY()) {
                y += speed;
            }



            double radiusX = gold.get(goldIndex).getX();
            double radiusY = gold.get(goldIndex).getY();

            if ((x <= radiusX+5 && x >= radiusX-5) && (y <= radiusY+5 && y >= radiusY-5) ) {

                gold.get(goldIndex).setDetected(true);
                golds++;
                System.out.println("interact");
            }
        }



    }

    public int getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public synchronized void startGold(){
        if(isRun){
            return;
        }
        isRun = true;
        thread = new Thread(this);
        thread.start();
    }
}
