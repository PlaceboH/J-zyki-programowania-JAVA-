package com.company;

import java.util.LinkedList;

public class Room {
    private static int nr;
    private int ileMiejsc;
    private int maxMiejsc;
    private int price;
    private LinkedList<Client> clients = new LinkedList();


    public Room(){
        nr += 1;
        ileMiejsc = 1;
        price = 100;
    }

    public Room(int ileMiejsc, int price){
        this.maxMiejsc = ileMiejsc;
        this.price = price;
        this.ileMiejsc = maxMiejsc;
    }

    public void addClient(Client client){
        if( ileMiejsc > 0 && client.getAge() > 17) {
            clients.add(client);
            ileMiejsc--;
        }
    }
    public void delClient(){
        if(ileMiejsc > 0 ){
            clients.removeLast();
            ileMiejsc++;
        }
    }

    public int getIleMiejsc() {
        return ileMiejsc;
    }

    public int getMaxMiejsc(){
        return maxMiejsc;
    }
    public int getNr() {
        return nr;
    }

    public int getPrice() {
        return price;
    }

    public LinkedList<Client> getClients() {
        return clients;
    }

}
