package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;


public class Simulation implements Runnable{

    private Thread thread;
    private Display display;
    private int width, height;
    private String title;
    private boolean isRun = false;

    Random rand = new Random();


    private ArrayList<Pirate> pirate;
    private ArrayList<Gold> gold;


    private BufferStrategy bs;
    private Graphics g;

    Visualization visualization;


    public Simulation(String t, int w, int h){
        width = w;
        height = h;
        title = t;
    }

    private void init(){
        display = new Display(title, width, height);
        pirate = new ArrayList<Pirate>();
        gold = new ArrayList<Gold>();
        visualization = new Visualization();

        addPirate(rand.nextInt(450), rand.nextInt(450), rand.nextInt(5) + 10);
        addPirate(rand.nextInt(450), rand.nextInt(450), rand.nextInt(5) + 10);

        addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);
        addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);
        addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);
        addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);
        addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);
        addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);

    }

    private void addPirate(int x, int y, int r){
        pirate.add(new Pirate(x, y, r));
    }

    private void addGold(int x, int y, int r){
        Gold newGold = new Gold(x, y, r);
        gold.add(newGold);
    }


    private void update(){
        for(int i = 0; i < pirate.size(); i++){
            pirate.get(i).update(gold);
        }
        for(int j = 0; j < gold.size(); j++){
            gold.get(j).update();
            if(gold.get(j).isDetected()){
                gold.get(j).stopGold();
                gold.remove(j);
                addGold(rand.nextInt(450), rand.nextInt(450), rand.nextInt(18) + 2);
            }
        }
    }



    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width, height);



        for(int i = 0; i < pirate.size(); i++){
            visualization.VisualizationPirate(g ,pirate.get(i));
        }
        for(int i = 0; i < gold.size(); i++){
            visualization.VisualizationGold(g ,gold.get(i));
        }


        bs.show();
        g.dispose();

    }


    @Override
    public void run() {
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        init();
        while(isRun){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if(delta >= 1) {
                update();
                render();
                delta--;
            }

            if(timer >= 1000000000){
                timer = 0;
            }
        }

        stop();
    }


    public synchronized void start(){
        if(isRun){
            return;
        }
        isRun = true;
        thread = new Thread(this);
        thread.start();
    }


    public synchronized void stop(){
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
