package com.company;


public class Gold implements Runnable {


    private boolean isRun = false;
    private Thread thread;
    private double x, y;
    private int r;
    private boolean detected = false;


    public Gold(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
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


    public void update(){

        if(!isRun){
            startGold();
        }

        if(detected){

            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public void setDetected(boolean detected) {
        this.detected = detected;
    }
    public boolean isDetected() {
        return detected;
    }

    @Override
    public void run() {

        System.out.println("gold thread");

        try {
             Thread.sleep(200);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    }



    public synchronized void startGold(){
        if(isRun){
            return;
        }
        isRun = true;
        thread = new Thread(this);
        thread.start();
    }


    public synchronized void stopGold(){
        if(!isRun){
            return;
        }
        isRun = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
